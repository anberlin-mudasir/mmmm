
#include "header.h"


void Set()
{
LABLE_L:
	system("cls");
	printf(" ������������������������������������������������������������������������������\n");
	printf(" ��������Ϸ�Ѷȼ���[0-9]: "); scanf("%d", &LEVEL);
	if (LEVEL<0 || LEVEL>9)  goto LABLE_L;

LABLE_P:
	system("cls");
	printf(" ������������������������������������������������������������������������������\n");
	printf(" �����ñ�������[1-5]: "); scanf("%d", &P); 
	PlayMusic(P);
	Sleep(3000); 
	//PlaySound(NULL, NULL, SND_FILENAME); //������ͣ
	if (P<1 || P>5)  goto LABLE_P;
	printf(" ����������ء���");
	getch();
	system("cls");
}