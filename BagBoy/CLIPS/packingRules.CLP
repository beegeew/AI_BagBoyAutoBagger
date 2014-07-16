



(defrule assignBox "Assigns boxes to sector 1"
	(bagged ?index1 ?x ?y ?z ?weight box ?material ?temp ?content ~thisSideUp ~thisSideUp ~thisSideUp ~thisSideUp)
	(bagged ?index1 ?x ?y ?z ?weight box ?material ?temp ?content ~fragile ~fragile ~fragile ~fragile)
	(bagged ?bagIndex ?index1)
	(sector ~1 ?otherIndex ?bagIndex)
=>
(assert(sector 1 ?index1 ?bagIndex)))




(defrule assignBox2 "Assigns boxes to sector 2"
	(bagged ?index1 ?x ?y ?z ?weight box ?material ?temp ?content ~thisSideUp ~thisSideUp ~thisSideUp ~thisSideUp)
	(bagged ?index1 ?x ?y ?z ?weight box ?material ?temp ?content ~fragile ~fragile ~fragile ~fragile)
	(bagged ?bagIndex ?index1)
	(not(sector ?i1 ?index1 ?bagIndex))
=>
(assert(sector 2 ?index1 ?bagIndex)))




(defrule assignBox3 "Assigns boxes to sector 3"
	(bagged ?index1 ?x ?y ?z ?weight box ?material ?temp ?content ~thisSideUp ~thisSideUp ~thisSideUp ~thisSideUp)
	(bagged ?index1 ?x ?y ?z ?weight box ?material ?temp ?content ~fragile ~fragile ~fragile ~fragile)
	(bagged ?bagIndex ?index1)
	(not(sector ?i1 ?index1 ?bagIndex))
=>
(assert(sector 3 ?index1 ?bagIndex)))




(defrule assignBox4 "Assigns boxes to sector 4"
	(bagged ?index1 ?x ?y ?z ?weight box ?material ?temp ?content ~thisSideUp ~thisSideUp ~thisSideUp ~thisSideUp)
	(bagged ?index1 ?x ?y ?z ?weight box ?material ?temp ?content ~fragile ~fragile ~fragile ~fragile)
	(bagged ?bagIndex ?index1)
	(not (sector ?i1 ?index1 ?bagIndex))
=>
(assert(sector 4 ?index1 ?bagIndex)))




(defrule assignCylinder "Assigns cylinders to sector 3"
	(bagged ?index1 ?x ?y ?z ?weight cylinder ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	(bagged ?bagIndex ?index1)
=>
(assert(sector 3 ?index1 ?bagIndex)))




(defrule assignCylinder2 "Assigns cylinders to sector 4"
	(bagged ?index1 ?x ?y ?z ?weight cylinder ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	(bagged ?bagIndex ?index1)
	(not(sector ?i1 ?index1 ?bagIndex))
=>
(assert(sector 4 ?index1 ?bagIndex)))




(defrule assignBagIrreg "Assigns bags and irregulars to sector 4"
	(or (bagged ?index1 ?x ?y ?z ?weight bag ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	    (bagged ?index1 ?x ?y ?z ?weight irregular ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
	(bagged ?bagIndex ?index1)
=>
(assert(sector 4 ?index1 ?bagIndex)))




(defrule assignBagIrreg2 "Assigns bags and irregulars to sector 3"
	(or (bagged ?index1 ?x ?y ?z ?weight bag ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	    (bagged ?index1 ?x ?y ?z ?weight irregular ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
	(bagged ?bagIndex ?index1)
	(not(sector ?i1 ?index1 ?bagIndex))
=>
(assert(sector 3 ?index1 ?bagIndex)))




(defrule stackStackable "Stacks identical stackable items"
	(bagged ?index1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 stackable)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 stackable)
	(or (and(sector 3 ?index1 ?bagIndex)
	        (sector 3 ?index2 ?bagIndex))
	    (and(sector 4 ?index1 ?bagIndex)
	        (sector 4 ?index2 ?bagIndex)))
=>
   (assert(stack ?index1 ?index2)))




(defrule stackIrregular "Stacks smaller items onto bigger items and will keep fragil on top"
	(bagged ?index1 ?x ?y ?z ?weight irregular ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	(bagged ?index2 ?x2 ?y2 ?z2 ?weight2 ?shape2 ?material2 ?temp2 ?content2 $?status1b $?status2b $?status3b $?status4b)
	(or (and(sector 3 ?index1 ?bagIndex)
	        (sector 3 ?index2 ?bagIndex))
	    (and(sector 4 ?index1 ?bagIndex)
	        (sector 4 ?index2 ?bagIndex)))
	(<= ?x ?x2)
	(<= ?y ?y2)
	(<= ?weight ?weight2)
=>
(if(and(neq $?status1 fragil)
       (neq $?status2 fragil)
       (neq $?status3 fragil)
       (neq $?status4 fragil)
       (eq $?status1b fragil)
       (eq $?status2b fragil)
       (eq $?status3b fragil)
       (eq $?status4b fragil))
then
else
   (assert(stack ?index1 ?index2))))




(defrule stackBag "Stacks smaller items onto bigger items and will keep fragil on top"
	(bagged ?index1 ?x ?y ?z ?weight bag ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	(bagged ?index2 ?x2 ?y2 ?z2 ?weight2 ~irregular ?material2 ?temp2 ?content2 $?status1b $?status2b $?status3b $?status4b)
	(or (and(sector 3 ?index1 ?bagIndex)
	        (sector 3 ?index2 ?bagIndex))
	    (and(sector 4 ?index1 ?bagIndex)
	        (sector 4 ?index2 ?bagIndex)))
	(<= ?x ?x2)
	(<= ?y ?y2)
	(<= ?weight ?weight2)
=>
(if(and(neq $?status1 fragil)
       (neq $?status2 fragil)
       (neq $?status3 fragil)
       (neq $?status4 fragil)
       (eq $?status1b fragil)
       (eq $?status2b fragil)
       (eq $?status3b fragil)
       (eq $?status4b fragil))
then
else
   (assert(stack ?index1 ?index2))))




(defrule stackBox "Stacks smaller items onto bigger items and will keep fragil on top"
	(bagged ?index1 ?x ?y ?z ?weight box ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	(bagged ?index2 ?x2 ?y2 ?z2 ?weight2 ~irregular ?material2 ?temp2 ?content2 $?status1b $?status2b $?status3b $?status4b)
	(bagged ?index2 ?x2 ?y2 ?z2 ?weight2 ~bag ?material2 ?temp2 ?content2 $?status1b $?status2b $?status3b $?status4b)
	(or (and(sector 3 ?index1 ?bagIndex)
	        (sector 3 ?index2 ?bagIndex))
	    (and(sector 4 ?index1 ?bagIndex)
	        (sector 4 ?index2 ?bagIndex)))
	(<= ?x ?x2)
	(<= ?y ?y2)
	(<= ?weight ?weight2)
=>
(if(and(neq $?status1 fragil)
       (neq $?status2 fragil)
       (neq $?status3 fragil)
       (neq $?status4 fragil)
       (eq $?status1b fragil)
       (eq $?status2b fragil)
       (eq $?status3b fragil)
       (eq $?status4b fragil))
then
else
   (assert(stack ?index1 ?index2))))




(defrule stackCylinder "Stacks smaller items onto bigger items and will keep fragil on top unless heavy"
	(bagged ?index1 ?x ?y ?z ?weight cylinder ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	(bagged ?index2 ?x2 ?y2 ?z2 ?weight2 cylinder ?material2 ?temp2 ?content2 $?status1b $?status2b $?status3b $?status4b)
	(or (and(sector 3 ?index1 ?bagIndex)
	        (sector 3 ?index2 ?bagIndex))
	    (and(sector 4 ?index1 ?bagIndex)
	        (sector 4 ?index2 ?bagIndex)))
	(<= ?x ?x2)
	(<= ?y ?y2)
	(<= ?weight ?weight2)
=>
(if(and(neq $?status1 fragil)
       (neq $?status2 fragil)
       (neq $?status3 fragil)
       (neq $?status4 fragil)
       (eq $?status1b fragil)
       (eq $?status2b fragil)
       (eq $?status3b fragil)
       (eq $?status4b fragil))
then
else
   (assert(stack ?index1 ?index2))))




(defrule besideGlass "restricts which items can be beside glass"
	(bagged ?index1 ?xa ?ya ?za ?weighta ?shapea glass ?tempa ?contenta $?status1a $?status2a $?status3a $?status4a)
	(or(bagged ?index2 ?x ?y ?z ?weight ?shape cardboard ?temp ?content $?status1 $?status2 $?status3 $?status4)
	   (bagged ?index2 ?x ?y ?z ?weight ?shape plastic ?temp ?content $?status1 $?status2 $?status3 $?status4)
	   (bagged ?index2 ?x ?y ?z ?weight ?shape paper ?temp ?content $?status1 $?status2 $?status3 $?status4))
	
=>
(assert(nextTo ?index1 ?index2)))




(defrule besideCardPlastPap "restricts which items can be beside cardboard plastic and paper"
	(or(bagged ?index1 ?xa ?ya ?za ?weighta ?shapea cardboard ?tempa ?contenta $?status1a $?status2a $?status3a $?status4a)
	   (bagged ?index1 ?xa ?ya ?za ?weighta ?shapea plastic ?tempa ?contenta $?status1a $?status2a $?status3a $?status4a)
	   (bagged ?index1 ?xa ?ya ?za ?weighta ?shapea paper ?tempa ?contenta $?status1a $?status2a $?status3a $?status4a))
	(or(bagged ?index2 ?x ?y ?z ?weight ?shape cardboard ?temp ?content $?status1 $?status2 $?status3 $?status4)
	   (bagged ?index2 ?x ?y ?z ?weight ?shape plastic ?temp ?content $?status1 $?status2 $?status3 $?status4)
	   (bagged ?index2 ?x ?y ?z ?weight ?shape paper ?temp ?content $?status1 $?status2 $?status3 $?status4)
	   (bagged ?index2 ?x ?y ?z ?weight ?shape metal ?temp ?content $?status1 $?status2 $?status3 $?status4))
=>
(assert(nextTo ?index1 ?index2)))




(defrule besideMetal "restricts which items can be beside metal"
	(bagged ?index1 ?xa ?ya ?za ?weighta ?shapea metal ?tempa ?contenta $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape metal ?temp ?content $?status1 $?status2 $?status3 $?status4)
=>
(assert(nextTo ?index1 ?index2)))




