set term gif animate size 800,300
set output "density1.gif"
set pm3d
set view map
set cbrange [0:1]

do for [i=3:25] {
    splot "zad1_den.dat" u 1:2:i w pm3d  title 'Bez zastawki'
}
set output

reset
set term gif animate size 800,300
set output "density2.gif"
set pm3d
set view map
set cbrange [0:1]

do for [i=3:25] {
    splot "zad2_den.dat" u 1:2:i w pm3d  title 'Z zastawka'
}
set output

reset
set term gif animate size 800,300
set output "density3.gif"
set pm3d
set view map
set cbrange [0:1]

do for [i=3:25] {
    splot "zad3_den.dat" u 1:2:i w pm3d  title 'Z zastawka Lax Friedrich'
}
set output

reset


set terminal png size 800,600
set o 'Zadanie1I.png'
set xl 'os X'
set yl 'os Y'
plot 'zad1_I.dat' u 1:2 w lines t 'Calka I'

set terminal png size 800,600
set o 'Zadanie1SrodekPakietu.png'
set xl 'os X'
set yl 'os Y'
plot 'zad1_packet.dat' u 1:2 w lines t 'Srodek pakietu'

reset


set terminal png size 800,600
set o 'Zadanie2I.png'
set xl 'os X'
set yl 'os Y'
plot 'zad2_I.dat' u 1:2 w lines t 'Calka I'

set terminal png size 800,600
set o 'Zadanie2SrodekPakietu.png'
set xl 'os X'
set yl 'os Y'
plot 'zad2_packet.dat' u 1:2 w lines t 'Srodek pakietu'

reset


set terminal png size 800,600
set o 'Zadanie3I.png'
set xl 'os X'
set yl 'os Y'
plot 'zad3_I.dat' u 1:2 w lines t 'Calka I'

set terminal png size 800,600
set o 'Zadanie3SrodekPakietu.png'
set xl 'os X'
set yl 'os Y'
plot 'zad3_packet.dat' u 1:2 w lines t 'Srodek pakietu'
