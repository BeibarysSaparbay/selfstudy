def sum_of_squares(n):
    results = []
    for _ in range(n):
        x = int(input())
        y = list(map(int, input().split()))
        total = 0
        for num in y:
            if num >= 0:
                total += num ** 2
        results.append(total)
    return results

def main():

    n = int(input())
    output = sum_of_squares(n)
    for result in output:
        print(result)


if __name__ == "__main__":
    main()
