from countswaps import CountSwaps
from countcompares import CountCompares


def merge(A):
    if len(A) > 1:

        mid = len(A) // 2

        L = CountSwaps([CountCompares(x.elem) for x in A[:mid]])
        R = CountSwaps([CountCompares(x.elem) for x in A[mid:]])

        mergeSort(L)
        mergeSort(R)

        i = j = k = 0

        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                A[k] = L[i]
                A.swaps += 1
                i += 1
            else:
                A[k] = R[j]
                A.swaps += 1
                j += 1
            k += 1


        while i < len(L):
            A[k] = L[i]
            A.swaps += 1
            i += 1
            k += 1

        while j < len(R):
            A[k] = R[j]
            A.swaps += 1
            j += 1
            k += 1

    return A


