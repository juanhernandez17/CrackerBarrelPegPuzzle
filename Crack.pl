:- use_module(library(lists),[member/2,select/3,reverse/2]).
:- use_module(library(apply),[maplist/3]).
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
%solves for i=0 and displays it
mainench(I):-
    select(I,[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14],Occu),
    format('======================~w==========================~n',[I]),
    solution([I],Occu,[],Moves),
    showsol(Moves,[I]),
    sleep(1).
%to automatically output i=0,1,2,3,4
mainench:-
    format('======================0==========================~n'),
    solution([0],[1,2,3,4,5,6,7,8,9,10,11,12,13,14],[],Moves0),
    showsol(Moves0,[0]),
    sleep(1),
    format('======================1==========================~n'),
    solution([1],[0,2,3,4,5,6,7,8,9,10,11,12,13,14],[],Moves1),
    showsol(Moves1,[1]),
    sleep(1),
    format('======================2==========================~n'),
    solution([2],[0,1,3,4,5,6,7,8,9,10,11,12,13,14],[],Moves2),
    showsol(Moves2,[2]),
    sleep(1),
    format('======================3==========================~n'),
    solution([3],[0,1,2,4,5,6,7,8,9,10,11,12,13,14],[],Moves3),
    showsol(Moves3,[3]),
    sleep(1),
    format('======================4==========================~n'),
    solution([4],[0,1,2,3,5,6,7,8,9,10,11,12,13,14],[],Moves4),
    showsol(Moves4,[4]).
%case of solution to stop recursion
solution(_,[_],Sol,Moves):-
    reverse(Sol,Moves).
%solution recursion function
solution(Unocu, Ocu, Sol, Moves):-
    select(F,Ocu,Newocu),%select F from Ocupied move the rest to NewOcupied
    select(O,Newocu,Newocu1),
    select(T,Unocu,Newfree),
    move(F,O,T),%check if FOT is possible
    solution([F,O|Newfree],[T | Newocu1],[move(F,O,T)|Sol],Moves).
    %call Funtion with new list
%Case to stop recursive display function
showsol([], Unocu) :-
	numlist(0,14, List),
	maplist([Y,X]>>(member(Y, Unocu) -> X = 0; X = x), List, [X0,X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14]),
	format('    ~w        ~n', [X0]),
	format('   ~w ~w      ~n', [X1,X2]),
	format('  ~w ~w ~w    ~n', [X3,X4,X5]),
	format(' ~w ~w ~w ~w  ~n', [X6,X7,X8,X9]),
	format('~w ~w ~w ~w ~w~n', [X10,X11,X12,X13,X14]).

showsol([move(F,O,T) | Tail], Unocu) :-
   %create a list of hole numbers 0-14
	numlist(0,14, List),
   %if Y(member of List) is member of unocupied the respective X = 0 else X = x
	maplist([Y,X]>>(member(Y, Unocu) -> X = 0; X = x),List,	[X0,X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14]),
	format('    ~w        ~n', [X0]),
	format('   ~w ~w      ~n', [X1,X2]),
	format('  ~w ~w ~w    ~n', [X3,X4,X5]),
	format(' ~w ~w ~w ~w  ~n', [X6,X7,X8,X9]),
	format('~w ~w ~w ~w ~w~n', [X10,X11,X12,X13,X14]),
	format('[F,O,T] = [~w, ~w, ~w]~n~n', [F,O,T]),
	select(T, Unocu, Newfree),
	showsol(Tail,  [F, O | Newfree]).

















