""" 
Psudokoden går ut på å dele arrayet på midten, ta elementet som er i midten og sette det inn.
Deretter tar man først halv del sitt midterste element og fortsetter til man ikke har noe igjen.
Tenker ved å bruke halerekursjon slipper man å returnere og man sitter igjen med en beholder
som har blitt sortert riktig

Input: Sorted array A, container array V
Output: Binary-sorted array A
Procedure Convert():
    i <- (len(A) - 1)/2
    v.append(A[i])
    if len(A) > 1 do:
        Convert(A[0...i - 1])
        Convert(A[i + 1...len(A) - 1])
"""

def innsetting(A, V):
    i = (len(A) - 1) // 2
    V.append(A[i])
    if len(A) > 1:
        list1 = A[:i]
        list2 = A[i:]
        innsetting(list1, V)
        innsetting(list2, V)
    return V

def main():
    l = []
    V = []
    for i in range(10):
        l.append(int(input()))
    print(innsetting(l,V))
main()