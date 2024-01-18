class Person:
    def __init__(self, pid, born):
        self.pid = pid
        self.born = born
    def getPid(self):
        return self.pid
    def getBorn(self):
        return self.born
			

if __name__ == '__main__':
    george = Person(200223, 2002)
    print(george.getPid(),5,george.getBorn())
