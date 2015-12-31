#include "header.h"


void  PlayMusic(int num =0)  //播放音乐
{
	char s[16] = ".\\Music\\M_.wav";
	s[9] = num + '0';
	PlaySound(s, NULL, SND_ASYNC | SND_LOOP);
}

void  PlayEnterMusic()  //播放进入游戏音乐
{

	PlaySound(".\\Music\\ENTER.wav", NULL, SND_ASYNC | SND_LOOP);
}

