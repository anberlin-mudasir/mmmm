
#include "header.h"


void Set()
{
LABLE_L:
	system("cls");
	printf(" ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※\n");
	printf(" 请设置游戏难度级别[0-9]: "); scanf("%d", &LEVEL);
	if (LEVEL<0 || LEVEL>9)  goto LABLE_L;

LABLE_P:
	system("cls");
	printf(" ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※\n");
	printf(" 请设置背景音乐[1-5]: "); scanf("%d", &P); 
	PlayMusic(P);
	Sleep(3000); 
	//PlaySound(NULL, NULL, SND_FILENAME); //音乐暂停
	if (P<1 || P>5)  goto LABLE_P;
	printf(" 按任意键返回……");
	getch();
	system("cls");
}