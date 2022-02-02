#!/bin/python

import random

lcm = []

for i in range(15):
    tmp = []
    for j in range(15):
        tmp.append(0)
    lcm.append(tmp)

for i in range(15):
    lcm[i][i] = "ANDD"
    for j in range(i+1, 15):
        lcm[i][j] = random.randint(0,2)
        if(lcm[i][j] == 0):
            lcm[i][j] = "ANDD"
        elif(lcm[i][j] == 1):
            lcm[i][j] = "ORR"
        else:
            lcm[i][j] = "NOTUSED"
        lcm[j][i] = lcm[i][j]


print("int[][] LCM = {")        
for row in lcm:
    strrow = "{ "
    for el in row:
        strrow += "{}, ".format(el)
    strrow = strrow[:len(strrow) - 2] + " "
    strrow += "}, "
    print(strrow)
print("};")
        
