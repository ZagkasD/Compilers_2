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
        else:
            return 2
        
class Employee(Person):
	def __init__(self, pid, born, afm, department):
		self.pid = pid
		self.born = born
		self.afm = afm
		self.department = department
	def getDepartment(self):
		return self.department
	def setDepartment(self, department):
		self.department = department
	def getPid(self):
		return self.afm

class StupidPrint:
	def __init__(self, employee):
		print(employee.pid)
		print(employee.born)
		print(employee.afm)
		print(employee.department)
  
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