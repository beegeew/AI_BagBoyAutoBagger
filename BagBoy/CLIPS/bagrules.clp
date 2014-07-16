(defglobal ?*bagcount* = 0)

(defrule bagItem "This takes an item that fits into a group and places it into a unique bag"
	?f1 <- (group ?n ?il)
	(bagged ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	?f2 <-(bag ?bagnum ?bagweight)
	(test (> ?*maxbagweight* (+ ?weight ?bagweight)))
	=>
	(bind ?bagweight (+ ?weight ?bagweight))
	(assert (bag ?bagnum ?bagweight))
	(retract ?f2)
	(assert (bagged ?bagnum ?il))
	(retract ?f1))
	
	
	
(defrule newBag "This rule starts a new bag with a single item"
	(declare (salience -100))
	?f1 <- (group ?n ?il)
	(bagged ?il ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	=>
	(assert (bag ?*bagcount* ?weight))
	(assert (bagged ?*bagcount* ?il))
	(bind ?*bagcount* (+ ?*bagcount* 1))
	(retract ?f1))