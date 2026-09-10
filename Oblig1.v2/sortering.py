
class Sortering:

    """ def insertion(self, usortert_liste):
        for i in range(len(usortert_liste) - 1):
            if i == 0:
                continue
            j = i
            while j > 0 and usortert_liste[j - 1] > usortert_liste[j]:
                holder = usortert_liste[j - 1]
                usortert_liste[j - 1] = usortert_liste[j]
                usortert_liste[j] = holder
                j -= 1 """
    def inserstionsort(self, A):
        n = len(A)
        for i in range(n):
            j = i
            while j > 0 and A[j] < A[j - 1]:
                A.swap(j, j - 1)
                j -= 1

        return A
    
    def merge(self, liste1, liste2, main_list):
        i = 0
        j = 0
        liste = []

        while (i < len(liste1) and j < len(liste2)):
            if liste1[i] <= liste2[j]:
                main_list[i + j] = liste1[i]
                i += 1
            else:
                main_list[i + j] = liste2[j]
                j += 1

        while i < len(liste1):
            main_list[i + j] = liste1[i]
            i += 1
        while j < len(liste2) - 1:
            main_list[i + j] = liste2[j]
            j += 1

        return liste

    def merge_sort(self, usortert_liste):
        if len(usortert_liste) <= 1:
            return usortert_liste
        
        i = (len(usortert_liste) // 2)
        list1 = self.merge_sort(usortert_liste[ : i])
        list2 = self.merge_sort(usortert_liste[i : ])
        return self.merge(list1, list2, usortert_liste)

def main():
    liste = []
    inp = input()
    f = open(inp, "r")

    for x in f:
        liste.append(int(x))
    
    liste2 = liste
    sort = Sortering()
    sort.insertion(liste)
    sort.merge_sort(liste2)
    print(liste)
    print(liste2)

main()