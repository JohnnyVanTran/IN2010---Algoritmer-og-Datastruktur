l = [1, 8, 3, 2, 5, 20, 4, 99, 80, 76]

def binSearch(sortedList, x):
    low = 0
    high = len(sortedList) - 1

    while (low <= high):
        i = int((high + low) / 2)
        if (x == sortedList[i]):
            return True
        if (x < sortedList[i]):
            high = i - 1
        if (x > sortedList[i]):
            low = i + 1
    
    return False

def bubble(l):
    for i in range(len(l) - 2):
        for j in range(len(l) - 2 - i):
            if l[j] > l[j + 1]:
                temp = l[j]
                l[j] = l[j + 1]
                l[j + 1] = temp

""" 
Selectionsort finner minste element i listen og setter
det fremst. Når elementene har byttet plass flytter pekeren
seg ett hakk opp.
"""
def selction(l):
    for i in range(len(l)):
        k = i
        for j in range(i + 1, len(l)):
            if l[j] < l[k]:
                k = j
        if k != i:
            temp = l[k]
            l[k] = l[i]
            l[i] = temp
"""
Insertion sort bobler nedover men kan bryte ut av whileloopen
"""
def insertion(l):
    for i in range (1, len(l)):
        k = i
        while k != 0 and l[k] < l[k - 1]:
            temp = l[k]
            l[k] = l[k - 1]
            l[k - 1] = temp
            k -= 1


def merge(list1, list2, listMain):
    i = 0
    j = 0
    while (i < len(list1) and j < len(list2)):
        if (list1[i] < list2[j]):
            listMain[i + j] = list1[i]
            i += 1
        else:
            listMain[i + j] = list2[j]
            j += 1
    while (i < len(list1)):
        listMain[i + j] = list1[i]
        i += 1
    while (j < len(list1)):
        listMain[i + j] = list2[j]
        j += 1
    return listMain

def mergeSort(l):
    if len(l) <= 1:
        return l
    i = int(len(l) / 2)
    list1 = mergeSort(l[0 : i])
    list2 = mergeSort(l[i : len(l)])
    return merge(list1, list2, l)

def partition(A, low, high):
    pivot = A[high]
    left = low
    right = high - 1

    while left <= right:
        while (left <= right) and (A[left] <= pivot):
            left += 1
        while (right >= left) and (A[right] >= pivot):
            right -= 1
        if (left < right):
            temp = A[left]
            A[left] = A[right]
            A[right] = temp
    
    temp = A[left]
    A[left] = A[high]
    A[high] = temp
    return left

def quickSort(A, low, high):
    if (low >= high):
        return A
    p = partition(A, low, high)
    quickSort(A, low, p - 1)
    quickSort(A, p, high)
    return A

print(l)
quickSort(l, 0, len(l) - 1)
print(l)