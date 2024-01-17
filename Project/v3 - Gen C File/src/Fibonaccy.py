# This python file creates an object in a function from a class
# and calls a function on that object
# def printNumber(self)
# 
# Works well

class Fibonacci:    
    def __init__(self,n):
        a, b = 0, 1
        while a < n:
            print(a, end=' ')
            a, b = b, a + b
        print()

if __name__ == '__main__':
    fib = Fibonacci(10)