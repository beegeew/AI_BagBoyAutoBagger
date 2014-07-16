(clear)



(defrule separateRaw "Separates raw from other items"
	(or (and (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa raw $?status1a $?status2a $?status3a $?status4a)
	         (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp ~raw $?status1 $?status2 $?status3 $?status4))
	    (and (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp raw $?status1 $?status2 $?status3 $?status4)
	         (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa ~raw $?status1a $?status2a $?status3a $?status4a)))
=>
(assert(separate ?index1 ?index2)))

	


(defrule separateHazardous "Seperates hazardous items from food but not neutral items"
	(or (and (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa hazardous $?status1a $?status2a $?status3a $?status4a)
	         (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp ~hazardous $?status1 $?status2 $?status3 $?status4)
	         (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp ~neutral $?status1 $?status2 $?status3 $?status4))
	    (and (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp hazardous $?status1 $?status2 $?status3 $?status4)
	         (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa ~hazardous $?status1a $?status2a $?status3a $?status4a)
	         (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa ~neutral $?status1a $?status2a $?status3a $?status4a)))
=>
(assert(separate ?index1 ?index2)))




(defrule separateHot "Seperates hot items from refrigerated and frozen but not room temp"
	(or (and (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala hot ?contenta $?status1a $?status2a $?status3a $?status4a)
	         (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ~hot ?content $?status1 $?status2 $?status3 $?status4)
	         (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ~roomTemp ?content $?status1 $?status2 $?status3 $?status4))
	    (and (bagged ?index2 ?x ?y ?z ?weight ?shape ?material hot ?content $?status1 $?status2 $?status3 $?status4)
	         (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ~hot ?contenta $?status1a $?status2a $?status3a $?status4a)
	         (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ~roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a)))
=>
(assert(separate ?index1 ?index2)))








(defrule pairRaw "Puts raw items together"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa raw $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp raw $?status1 $?status2 $?status3 $?status4)
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 2))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa raw $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))




(defrule pairHazardous "Puts hazardous items together"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa hazardous $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp hazardous $?status1 $?status2 $?status3 $?status4)
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 2))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa hazardous $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))




(defrule pairProduce "Puts fruits and veggies together"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa produce $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp produce $?status1 $?status2 $?status3 $?status4)
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 2))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa produce $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))




(defrule pairDryFood "Puts dry food items together"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa dryFood $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp dryFood $?status1 $?status2 $?status3 $?status4)
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 2))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa dryFood $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))




(defrule pairNeutral "Puts neutral items together"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa neutral $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp neutral $?status1 $?status2 $?status3 $?status4)
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 2))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa neutral $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))




(defrule pairFrozen "Puts frozen items together"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala frozen ?contenta $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material frozen ?content $?status1 $?status2 $?status3 $?status4)
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 2))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala frozen ?contenta $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))




(defrule pairRefrigerated "Puts refrigerated items together"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala refrigerated ?contenta $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material refrigerated ?content $?status1 $?status2 $?status3 $?status4)
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 2))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala refrigerated ?contenta $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))




(defrule pairRoomTemp "Puts roomTemp items together"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material roomTemp ?content $?status1 $?status2 $?status3 $?status4)
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 2))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))




(defrule pairRoomTempRefrigerated "Puts roomTemp items with refrigerated items"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a)
	(bagged ?index2 ?x ?y ?z ?weight ?shape ?material refrigerated ?content $?status1 $?status2 $?status3 $?status4)
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 1))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))




(defrule pairRoomTempFrozenHot "Puts roomTemp items with frozen or hot items"
	?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a)
	(or (bagged ?index2 ?x ?y ?z ?weight ?shape ?material frozen ?content $?status1 $?status2 $?status3 $?status4)
	    (bagged ?index2 ?x ?y ?z ?weight ?shape ?material hot ?content $?status1 $?status2 $?status3 $?status4))
	(not (or (separate ?index1 ?index2)
	         (separate ?index2 ?index1)))
=>
(assert(pair ?index1 ?index2 0))
(assert(temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a))
(retract ?f1))








(defrule separateItems "Unpairs invalid item pairs"
	 ?f1 <- (pair ?i1 ?i2 ?prioritya)
	(or (separate ?i1 ?i2 ?priority)
            (separate ?i2 ?i1 ?priority))
=>
(retract  ?f1))




(defrule cantGroup "Checks if any items can't be put in a group"
	(pair ?i1 ?i2 ?priority)
	(group ?n ?i2)
	(group ?n ?i3)
	(or (separate ?i1 ?i3)
	    (separate ?i3 ?i1))
=>
(assert(dontGroup ?n ?i1)))








(defrule groupPairs "Puts high priority pairs with valid groups"
	?f1 <- (pair ?i1 ?i2 2)
	?f2 <- (temporary ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	(group ?n ?i2) 
	(not (dontGroup ?n ?i1))
=>
(assert(group ?n ?i1))
(assert(bagged ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
(retract ?f1)
(retract ?f2))




(defrule groupPairs2 "Puts medium priority pairs with valid groups"
	?f1 <- (pair ?i1 ?i2 2)
	?f2 <- (temporary ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	(group ?n ?i2)
	(not (dontGroup ?n ?i1))
=>
(assert(group ?n ?i1))
(assert(bagged ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
(retract ?f1)
(retract ?f2))




(defrule groupPairs3 "Puts low priority pairs with valid groups"
	?f1 <- (pair ?i1 ?i2 2)
	?f2 <- (temporary ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
	(group ?n ?i2)
	(not (dontGroup ?n ?i1))
=>
(assert(group ?n ?i1))
(assert(bagged ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
(retract ?f1)
(retract ?f2))




(defglobal ?*count* = 0)




(defrule groupLeftoverPairs "Puts any leftover pairs in a new group"
	?f1 <- (pair ?i1 ?i2 ?priority)
	?f2 <- (temporary ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
=>
(assert(group ?*count* ?i1))
(bind ?*count* (+ ?*count* 1))
(assert(bagged ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
(retract ?f1)
(retract ?f2))




(defrule newGroup "Starts a new group with one item"
	 ?f1 <- (product ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
=>
(assert(group ?*count* ?i1))
(bind ?*count* (+ ?*count* 1))
(assert(bagged ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
(retract ?f1))




(defrule cleanup1 "Deletes separate facts"
	(declare(salience -10))
	?f1 <- (separate ?i1 ?i2)
=>
(retract ?f1))




(defrule cleanup2 "Deletes dontGroup facts"
	(declare(salience -10))
	?f1 <- (dontGroup ?n ?i1)
=>
(retract ?f1))



