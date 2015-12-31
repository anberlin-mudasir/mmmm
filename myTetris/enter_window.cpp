#include "header.h"

void Enter()
{
	char inputNum[1024];
	PlayEnterMusic();

LABLE_MENU:
	system("color 0A");
	system("cls");
	printf("\n\n");
	printf("                               ■■■■■■■■■                              \n");
	printf("                               ■☆俄罗斯方块☆■                              \n");
	printf("                               ■■■■■■■■■                              \n");
	printf(" ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※\n");
	printf(" ※╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬※\n");
	printf(" ※╬●●●●●●●●●●●●●   1.开始游戏     ●●●●●●●●●●●●●╬※\n");
	printf(" ※╬●  ★  ☆  ★  ☆  ★  ●   2.游戏设置     ●  ★  ☆  ★  ☆  ★  ●╬※\n");
	printf(" ※╬●  ★  ☆  ★  ☆  ★  ●   3.游戏说明     ●  ★  ☆  ★  ☆  ★  ●╬※\n");
	printf(" ※╬●●●●●●●●●●●●●   0.退出游戏     ●●●●●●●●●●●●●╬※\n");
	printf(" ※╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬※\n");
	printf(" ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※\n");
	printf("\n\n请输入选择序号[0-3]: ");
	gets(inputNum);
	if (strlen(inputNum) > 1) goto LABLE_MENU;

	switch (inputNum[0])
	{
	case '0':
		flag = 0;
		break;
	case '1':
		flag = 1;
		break;
	case '2':
		Set();
		goto LABLE_MENU;
		break;
	case '3':
		Readme();
		goto LABLE_MENU;
		break;
	default:
		goto LABLE_MENU;
		break;
	}
	PlaySound(NULL, NULL, NULL);
}
