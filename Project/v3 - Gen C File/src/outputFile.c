#include <stdio.h>

typedef struct{ 
	int pid;
	int born;
}Person;
void Person_init (Person *self,int pid,int born) {
		self->pid = pid;
		self->born = born;

}
int  Person_getPid (Person *self) {
		return self->pid;

}
int  Person_getBorn (Person *self) {
		return self->born;

}
int  Person_millenium (Person *self) {
		if (self->born<2000){
			printf ("%d \n",self->pid);
			if (self->born<2004){
				return self->born;
			}
		}
	return 0;

}
int main(){
	Person	george;
	Person_init(&george, 200223,2002);
	Person	john;
	Person_init(&john, 200055,2000);
	printf ("%d \n",Person_getBorn(&george  ));
	printf ("%d \n",Person_getBorn(&john  ));
	return 0;
}
