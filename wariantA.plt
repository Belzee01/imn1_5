reset
set term gif animate size 800,300
set output "anim1.gif"
n=25    #n frames
set pm3d
set view map
set size ratio -1
set cbrange [0:1]

i=3
load "animacja_zad1.plt"
set output

reset
set term gif animate size 800,300
set output "anim2.gif"
n=25    #n frames
set pm3d
set view map
set size ratio -1
set cbrange [0:1]

i=3
load "animacja_zad2.plt"
set output

reset
set term gif animate size 800,300
set output "anim3.gif"
n=25    #n frames
set pm3d
set view map
set size ratio -1
set cbrange [0:1]

i=3
load "animacja_zad3.plt"
set output