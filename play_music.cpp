#include "header.h"


void  PlayMusic(int num =0)  //��������
{
	char s[16] = ".\\Music\\M_.wav";
	s[9] = num + '0';
	PlaySound(s, NULL, SND_ASYNC | SND_LOOP);
}

void  PlayEnterMusic()  //���Ž�����Ϸ����
{

	PlaySound(".\\Music\\ENTER.wav", NULL, SND_ASYNC | SND_LOOP);
}

