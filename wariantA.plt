set terminal png size 800,600
set o 'Potential1.png'
set xl 'os X'
set yl 'os Y'
set view map
set size ratio -1
set title 'Zad2. Przeplyw potencjalny'
set contours
set contour base
set cntrparam levels 30
unset clabel
set pm3d
splot 'warA_pot.dat' u 1:2:3 w pm3d lt -1 t ''

set terminal png size 800,600
set o 'Wirowosc1.png'
set xl 'os X'
set yl 'os Y'
set view map
set size ratio -1
set title 'Zad2. Wir'
set contours
set contour base
set cntrparam levels 30
unset clabel
set pm3d
splot 'warA_wir.dat' u 1:2:3 w pm3d lt -1 t ''

set terminal png size 800,600
set o 'VelocityI50.png'
set xl 'os X'
set yl 'os Y'
set title 'Wartosc predkosci w i =50'
plot 'warA_vel.dat' u 1:2 w lines t 'Predkosc numerycznie', \
'warA_vel.dat' u 1:3 w lines t 'Predkosc analiztycznie'

set terminal png size 800,600
set o 'StrumienI50.png'
set xl 'os X'
set yl 'os Y'
set title 'Funkcja strumienia w i = 50'
plot 'warA_pot_i_50.dat' u 1:2 w lines t 'Strumien numerycznie', \
'warA_pot_i_50.dat' u 1:3 w lines t 'Strumien analitycznie'

set terminal png size 800,600
set o 'WirowoscI50.png'
set xl 'os X'
set yl 'os Y'
set title 'Funckaj wiru w i =50'
plot 'warA_pot_i_50.dat' u 1:4 w lines t 'Wir numerycznie', \
'warA_pot_i_50.dat' u 1:5 w lines t 'Wir analitycznie'

set terminal png size 800,600
set o 'StrumienI250.png'
set xl 'os X'
set yl 'os Y'
set title 'Funkcja strumienia w i = 250'
plot 'warA_pot_i_250.dat' u 1:2 w lines t 'Strumien numerycznie', \
'warA_pot_i_250.dat' u 1:3 w lines t 'Strumien analitycznie'

set terminal png size 800,600
set o 'WirowoscI250.png'
set xl 'os X'
set yl 'os Y'
set title 'Funckaj wiru w i =250'
plot 'warA_pot_i_250.dat' u 1:4 w lines t 'Wir numerycznie', \
'warA_pot_i_250.dat' u 1:5 w lines t 'Wir analitycznie'


########

set terminal png size 800,600
set o 'Potential2Q1.png'
set xl 'os X'
set yl 'os Y'
set view map
set size ratio -1
set title 'Zad2. Przeplyw potencjalny'
set contours
set contour base
set cntrparam levels 30
unset clabel
set pm3d
splot 'warA_pot2_Q1.dat' u 1:2:3 w pm3d lt -1 t ''


set terminal png size 800,600
set o 'Potential2Q2.png'
set xl 'os X'
set yl 'os Y'
set view map
set size ratio -1
set title 'Zad2. Przeplyw potencjalny'
set contours
set contour base
set cntrparam levels 30
unset clabel
set pm3d
splot 'warA_pot2_Q150.dat' u 1:2:3 w pm3d lt -1 t ''

set terminal png size 800,600
set o 'Potential2Q3.png'
set xl 'os X'
set yl 'os Y'
set view map
set size ratio -1
set title 'Zad2. Przeplyw potencjalny'
set contours
set contour base
set cntrparam levels 30
unset clabel
set pm3d
splot 'warA_pot2_Q400.dat' u 1:2:3 w pm3d lt -1 t ''

set terminal png size 800,600
set o 'Wir2Q3.png'
set xl 'os X'
set yl 'os Y'
set view map
set size ratio -1
set title 'Zad2. Przeplyw wiru'
set contours
set contour base
set cntrparam levels 30
unset clabel
set pm3d
splot 'warA_wir2_Q400.dat' u 1:2:3 w pm3d lt -1 t ''

reset

set out "VelocityQ1U.png"
set xlabel "x"
set ylabel "y"
set size ratio -1
set view map
unset key
plot "warA_pot2_Q1_U.dat" u 1:2:3 title "u(x,y)" w image

reset

set out "VelocityQ1V.png"
set xlabel "x"
set ylabel "y"
set size ratio -1
set view map
unset key
plot "warA_pot2_Q1_V.dat" u 1:2:3 title "u(x,y)" w image


reset

set out "VelocityQ2U.png"
set xlabel "x"
set ylabel "y"
set size ratio -1
set view map
unset key
plot "warA_pot2_Q150_U.dat" u 1:2:3 title "u(x,y)" w image

reset

set out "VelocityQ2V.png"
set xlabel "x"
set ylabel "y"
set size ratio -1
set view map
unset key
plot "warA_pot2_Q150_V.dat" u 1:2:3 title "u(x,y)" w image


reset

set out "VelocityQ3U.png"
set xlabel "x"
set ylabel "y"
set size ratio -1
set view map
unset key
plot "warA_pot2_Q400_U.dat" u 1:2:3 title "u(x,y)" w image

reset

set out "VelocityQ3V.png"
set xlabel "x"
set ylabel "y"
set size ratio -1
set view map
unset key
plot "warA_pot2_Q400_V.dat" u 1:2:3 title "u(x,y)" w image