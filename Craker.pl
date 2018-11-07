%moves(From, Over, To)
move(F,1,T):-
   member([F,T],[[0,3],[3,0]]).
move(F,2,T):-
   member([F,T],[[0,5],[5,0]]).
move(F,3,T):-
   member([F,T],[[1,6],[6,1]]).
move(F,4,T):-
   member([F,T],[[1,8],[8,1],[2,7],[7,2],[3,5],[5,3]]).
move(F,5,T):-
   member([F,T],[[2,9],[9,2]]).
move(F,6,T):-
   member([F,T],[[3,10],[3,10]]).
move(F,7,T):-
   member([F,T],[[3,12],[12,3],[4,11],[11,4],[8,6],[6,8]]).
move(F,8,T):-
   member([F,T],[[5,12],[12,5],[4,13],[13,4],[9,7],[7,9]]).
move(F,9,T):-
   member([F,T],[[5,14],[14,5]]).
move(F,11,T):-
   member([F,T],[[10,12],[12,10]]).
move(F,12,T):-
   member([F,T],[[11,13],[13,11]]).
move(F,13,T):-
   member([F,T],[[14,12],[12,14]]).
