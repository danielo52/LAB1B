
                                    ****** Information about the Project *****

The modules were primarily (read solely) implemented in order to increase the clarity of the project within the IDE.
This means that the allocation of the classes etc. might not be perfect at all times, but again, these partitions were
made for us (author and TA) to easier gain a comprehensive perception of the project and its components (classes, interfaces etc).

(So for instance, TimerListener should be moved to the Controller package).


                    *** Things that could've/should've been Implemented in the Code but weren't ***

Note: these suggested changes were not implemented in the actual code due to: we came up with a better
solution after already implemented the current solution. We then had a limited amount of time, and had to
prioritize other things to change/implement in the code. (Might go without saying, but we'll mention it just in case.
A lot of these ideas (suggested changes) were thought of after we've already continued with the Assignments, and therefore
we did not take the time to go back to prior Assignments and make changes).

                                    *** These suggested changes include ***

--> The bed and turbo situation could have been simplified (read: improved) by using a Strategy Pattern
    (ex: interface: ITurbo, classes: hasTurbo & noTurbo implements ITurbo.
            LandVehicle: instance variable ITurbo turbo;
            Saab (parent): ITurbo turbo = new hasTurbo(); Volvo/Scania(parent): ITurbo turbo = new noTurbo();

-->

