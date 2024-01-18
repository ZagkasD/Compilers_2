class Person:
    def __init__(self, pid, born):
        self.pid = pid
        self.born = born
    def getPid(self):
        return self.pid
    def getBorn(self):
        return self.born
    def millenium(self):
        if self.born < 2000:
            print(self.pid)
            return self.pid
        if self.born < 2004:
            return self.born

if __name__ == '__main__':
	george = Person(200223, 2002)
	john = Person(200055, 2000)
	print(george.getBorn())
	print(john.getBorn())
