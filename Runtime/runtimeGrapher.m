% Graphing accessory for Runtime exploration

% Start by chaing the values in the array to those that you used. My 
% example shows 4 different values of n, with 4 corresponding runtimes
% output by the Java program.

% First, an array of values of n that you chose. For example:
n = [1E6, 1E7, 1E8, 5E8, 1E9]

% Then, an array of runtimes that you found. For example:
runtimes = [16, 187, 1968, 9047, 19797]

% Then, Matlab's plotting functions. It takes 2 to make a pretty graph:
hold on
plot(n, runtimes, 'b-') % plots the lines in blue (b)
plot(n, runtimes, 'bo') % plots the points

% You can add another plot to the same graph if you want. (No need to,
% though.)

% n2 = [1E8, 3E8, 7E8, 1E9]
% runtimes2 = [4000, 5000, 6000, 7000]
% plot(n2, runtimes2, 'r-')
% plot(n2, runtimes2, 'ro')

% And so on...

% Save a copy of the graph by choosing the graph's File/Save-as option.
% png is a nice file format to use because it is compressed, but loses 
% no info, unlike jpg.
