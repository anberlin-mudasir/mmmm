#include "header.h"
#include "draw_tetris.h"

int main(int argc, char *argv[])
{
	system("title ����˹����");
	Enter();
	if (!flag)
	{
		return 0;
	}
	DrawTetris myTetris;
	myTetris.start();

	return 0;
}