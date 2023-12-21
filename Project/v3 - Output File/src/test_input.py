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
			return 1


if __name__ == '__main__':
	george = Person(200223, 2002)
	john = Person(200055, 2000)
	peter = Employee(200122, 2001, 990122, 1)
	print(george.getBorn())
	print(john.getBorn())
	print(peter.getBorn())
	print(peter.millenium())
	print(peter.getDepartment())
	peter.setDepartment(2)
	print(peter.getDepartment())
	print(george.getPid())
	print(peter.getPid())
	stupid = StupidPrint(peter)