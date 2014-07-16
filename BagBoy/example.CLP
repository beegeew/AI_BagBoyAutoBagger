(defglobal MAIN ?*count* = 0)

(defrule MAIN::separateRaw "Separates raw from other food and neutral items"
   (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa raw $?status1a $?status2a $?status3a $?status4a)
   (or  (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp dryFood $?status1 $?status2 $?status3 $?status4)
        (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp produce $?status1 $?status2 $?status3 $?status4)
        (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp neutral $?status1 $?status2 $?status3 $?status4))
   =>
   (assert (separate ?index1 ?index2)))

(defrule MAIN::separateHazardous "Seperates hazardous items from food"
   (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa hazardous $?status1a $?status2a $?status3a $?status4a)
   (or  (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp dryFood $?status1 $?status2 $?status3 $?status4)
        (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp produce $?status1 $?status2 $?status3 $?status4)
        (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp raw $?status1 $?status2 $?status3 $?status4))
   =>
   (assert (separate ?index1 ?index2)))

(defrule MAIN::separateHot "Seperates hot items from refrigerated and frozen"
   (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala hot ?contenta $?status1a $?status2a $?status3a $?status4a)
   (or  (bagged ?index2 ?x ?y ?z ?weight ?shape ?material frozen ?content $?status1 $?status2 $?status3 $?status4)
        (bagged ?index2 ?x ?y ?z ?weight ?shape ?material refrigerated ?content $?status1 $?status2 $?status3 $?status4))
   =>
   (assert (separate ?index1 ?index2)))

(defrule MAIN::pairRaw "Puts raw items together"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa raw $?status1a $?status2a $?status3a $?status4a)
   (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp raw $?status1 $?status2 $?status3 $?status4)
   =>
   (assert (pair ?index1 ?index2 2))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa raw $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::pairHazardous "Puts hazardous items together"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa hazardous $?status1a $?status2a $?status3a $?status4a)
   (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp hazardous $?status1 $?status2 $?status3 $?status4)
   =>
   (assert (pair ?index1 ?index2 2))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa hazardous $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::pairProduce "Puts fruits and veggies together"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa produce $?status1a $?status2a $?status3a $?status4a)
   (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp produce $?status1 $?status2 $?status3 $?status4)
   =>
   (assert (pair ?index1 ?index2 2))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa produce $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::pairDryFood "Puts dry food items together"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa dryFood $?status1a $?status2a $?status3a $?status4a)
   (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp dryFood $?status1 $?status2 $?status3 $?status4)
   =>
   (assert (pair ?index1 ?index2 2))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa dryFood $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::pairNeutral "Puts neutral items together"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa neutral $?status1a $?status2a $?status3a $?status4a)
   (bagged ?index2 ?x ?y ?z ?weight ?shape ?material ?temp neutral $?status1 $?status2 $?status3 $?status4)
   =>
   (assert (pair ?index1 ?index2 2))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala ?tempa neutral $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::pairFrozen "Puts frozen items together"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala frozen ?contenta $?status1a $?status2a $?status3a $?status4a)
   (bagged ?index2 ?x ?y ?z ?weight ?shape ?material frozen ?content $?status1 $?status2 $?status3 $?status4)
   =>
   (assert (pair ?index1 ?index2 2))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala frozen ?contenta $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::pairRefrigerated "Puts refrigerated items together"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala refrigerated ?contenta $?status1a $?status2a $?status3a $?status4a)
   (bagged ?index2 ?x ?y ?z ?weight ?shape ?material refrigerated ?content $?status1 $?status2 $?status3 $?status4)
   =>
   (assert (pair ?index1 ?index2 2))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala refrigerated ?contenta $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::pairRoomTemp "Puts roomTemp items together"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a)
   (bagged ?index2 ?x ?y ?z ?weight ?shape ?material roomTemp ?content $?status1 $?status2 $?status3 $?status4)
   =>
   (assert (pair ?index1 ?index2 2))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::pairRoomTempRefrigerated "Puts roomTemp items with refrigerated items"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a)
   (bagged ?index2 ?x ?y ?z ?weight ?shape ?material refrigerated ?content $?status1 $?status2 $?status3 $?status4)
   =>
   (assert (pair ?index1 ?index2 1))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::pairRoomTempFrozenHot "Puts roomTemp items with frozen or hot items"
   ?f1 <- (product ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a)
   (or  (bagged ?index2 ?x ?y ?z ?weight ?shape ?material frozen ?content $?status1 $?status2 $?status3 $?status4)
        (bagged ?index2 ?x ?y ?z ?weight ?shape ?material hot ?content $?status1 $?status2 $?status3 $?status4))
   =>
   (assert (pair ?index1 ?index2 0))
   (assert (temporary ?index1 ?xa ?ya ?za ?weighta ?shapea ?materiala roomTemp ?contenta $?status1a $?status2a $?status3a $?status4a))
   (retract ?f1))

(defrule MAIN::separateItems "Unpairs invalid item pairs"
   ?f1 <- (pair ?i1 ?i2 ?prioritya)
   (or  (separate ?i1 ?i2 ?priority)
        (separate ?i2 ?i1 ?priority))
   =>
   (retract ?f1))

(defrule MAIN::cantGroup "Checks if any items can't be put in a group"
   (pair ?i1 ?i2 ?priority)
   (group ?n ?i2)
   (group ?n ?i3)
   (separate ?i1 ?i3)
   =>
   (assert (dontGroup ?n ?i1)))

(defrule MAIN::groupPairs "Puts high priority pairs with valid groups"
   ?f1 <- (pair ?i1 ?i2 2)
   ?f2 <- (temporary ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
   (group ?n ?i2)
   (not (dontGroup ?n ?i1))
   =>
   (assert (group ?n ?i1))
   (assert (bagged ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
   (retract ?f1)
   (retract ?f2))

(defrule MAIN::groupPairs2 "Puts medium priority pairs with valid groups"
   ?f1 <- (pair ?i1 ?i2 2)
   ?f2 <- (temporary ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
   (group ?n ?i2)
   (not (dontGroup ?n ?i1))
   =>
   (assert (group ?n ?i1))
   (assert (bagged ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
   (retract ?f1)
   (retract ?f2))

(defrule MAIN::groupPairs3 "Puts low priority pairs with valid groups"
   ?f1 <- (pair ?i1 ?i2 2)
   ?f2 <- (temporary ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4)
   (group ?n ?i2)
   (not (dontGroup ?n ?i1))
   =>
   (assert (group ?n ?i1))
   (assert (bagged ?i1 ?x ?y ?z ?weight ?shape ?material ?temp ?content $?status1 $?status2 $?status3 $?status4))
   (retract ?f1)
   (retract ?f2))

