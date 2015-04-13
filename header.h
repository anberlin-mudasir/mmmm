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

static int flag = 1,  //是否开始游戏
	P = 1, //当前音乐编号
	LEVEL = 0; //难度级别

#endif // _HEADER_H_