#ifndef _HEADER_H_
#define _HEADER_H_

#include <windows.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <conio.h>
#pragma comment(lib, "winmm.lib")

void Set();
void Enter();
void Readme();
void PlayMusic(int);
void PlayEnterMusic();

static int flag = 1,  //�Ƿ�ʼ��Ϸ
	P = 1, //��ǰ���ֱ��
	LEVEL = 0; //�Ѷȼ���

#endif // _HEADER_H_