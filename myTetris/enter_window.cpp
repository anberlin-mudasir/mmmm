#include "header.h"

void Enter()
{
	char inputNum[1024];
	PlayEnterMusic();

LABLE_MENU:
	system("color 0A");
	system("cls");
	printf("\n\n");
	printf("                               ������������������                              \n");
	printf("                               �������˹������                              \n");
	printf("                               ������������������                              \n");
	printf(" ������������������������������������������������������������������������������\n");
	printf(" ���p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p��\n");
	printf(" ���p��������������   1.��ʼ��Ϸ     ��������������p��\n");
	printf(" ���p��  ��  ��  ��  ��  ��  ��   2.��Ϸ����     ��  ��  ��  ��  ��  ��  ��p��\n");
	printf(" ���p��  ��  ��  ��  ��  ��  ��   3.��Ϸ˵��     ��  ��  ��  ��  ��  ��  ��p��\n");
	printf(" ���p��������������   0.�˳���Ϸ     ��������������p��\n");
	printf(" ���p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p�p��\n");
	printf(" ������������������������������������������������������������������������������\n");
	printf("\n\n������ѡ�����[0-3]: ");
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
