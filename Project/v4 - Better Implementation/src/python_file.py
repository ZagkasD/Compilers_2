class Person:
	def __init__(self, pid, born) :
		self.pid = pid
		self.born = born
	def getPid(self):
		return self.pid
	def getBorn(self):
		return self.born
	def millenium(self):
		if self.born < 2000:
			return 1
		else:
			return 2

