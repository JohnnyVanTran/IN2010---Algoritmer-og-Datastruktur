def inserstionsort(A):
    n = len(A)
    for i in range(n):
        j = i
        while j > 0 and A[j] < A[j - 1]:
            A.swap(j, j - 1)
            j -= 1

    return A
