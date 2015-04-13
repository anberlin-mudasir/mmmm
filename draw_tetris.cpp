#include "draw_tetris.h"


DrawTetris::DrawTetris() {
	level = LEVEL;
	score = 0;
	memset(data, 0, sizeof(data));
}

void DrawTetris::start(void){
	system("color 07");
	console.Open();
	console.SetTitle("俄罗斯方块");
	console.RemoveCursor();
	console.SetWindowRect(40 - 1, 21 - 1);
	console.SetBufSize(40, 21);
	console.OutputStringNoMove(0, 0, bg,0);
	DrawScoreAndLevel();
	srand(time(0));
	next = rand() % 7;
	DrawNext();
	for (int ch = getch(); ch != 0xD; ch = getch()); //按回车键开始游戏
	x = 4, y = -2, c = next, z = 0;
	DrawNext();
	PlayMusic(P);
	DealKey();
}

void DrawTetris::DrawScoreAndLevel(void) {
	char tmp[6];
	sprintf(tmp, "%05d", score);
	console.OutputStringNoMove(31, 19, tmp, 5);
	sprintf(tmp, "%1d", level);
	console.OutputStringNoMove(35, 15, tmp, 1);
}

void DrawTetris::DrawNext(void) {
	for (int i = 0; i < 2; ++i) {
		for (int j = 0; j < 4; ++j) {
			console.OutputStringNoMove(28 + j * 2, 10 + i, bk[next][0][i][j] == 0 ? "　":"■", 2);
		}
	}
}

void DrawTetris::DrawOver(void) {
	console.OutputStringNoMove(28, 10, "ＧＡＭＥ",0);
	console.OutputStringNoMove(28, 11, "ＯＶＥＲ",0);
	system("color C");
	getchar();
}

void DrawTetris::DrawBlock(WORD color) {
	for (int i = 0; i < 4; ++i) {
		if (y + i < 0 || y + i >= 19) continue;
		for (int j = 0; j < 4; ++j) {
			if (bk[c][z][i][j] == 1) {
				console.SetColor(color);
				console.GotoXY(2 + x * 2 + j * 2, 1 + y + i);
				console.OutputString("■", 2);
			}
		}
	}
}

bool DrawTetris::InRange(int x, int y, int c, int z) {
	for (int i = 0; i<4; ++i) {
		for (int j = 0; j<4; ++j) {
			if (bk[c][z][i][j] == 1) {
				if (y + i < 0) continue;
				if (y + i >= 19 || x + j<0 || x + j >= 11 || data[y + i][x + j] == 1) return false;
			}
		}
	}
	return true;
}

void DrawTetris::RemoveRow(void) {
	int line_count = 0;
	for (int i = 0; i < 19; ++i) {
		if (0 == memcmp(data[i], FULLLINE, 11)) {
			++line_count;
			for (int m = 0; m < 11; ++m) {
				for (int n = i; n > 1; --n) {
					data[n][m] == data[n - 1][m];
					console.SetColor(data[n][m] == 1 ? COLOR_B : COLOR_C);
					console.GotoXY(2 + m * 2, 1 + n);
					console.OutputString("■", 2);
				}
				data[0][m] = 0;
				console.OutputStringNoMove(2 + m * 2, 1, "■", 2);
			}
		}
	}

	if (line_count == 0) return;
	int add_score = 0;
	switch (line_count) {
	case 1:
		add_score = 100;
		break;
	case 2:
		add_score = 300;
		break;
	case 3:
		add_score = 500;
		break;
	case 4:
		add_score = 1000;
		break;
	default:
		break;
	}
	score += add_score;
	if (score > 99999) {
		score = 0;
		if (++level >= 9) level = 0;
	}
	DrawScoreAndLevel();
}

void DrawTetris::MoveTrans(void) { 
	if (InRange(x, y, c, (z + 1) % 4)) {

		DrawBlock(COLOR_C);
		z = (z + 1) % 4;
		DrawBlock(COLOR_A);
	}
}

void DrawTetris::MoveLeft(void) { 
	if (InRange(x - 1, y, c, z)) {

		DrawBlock(COLOR_C);
		--x;
		DrawBlock(COLOR_A);
	}
}

void DrawTetris::MoveRight(void) { 
	if (InRange(x + 1, y, c, z)) {

		DrawBlock(COLOR_C);
		++x;
		DrawBlock(COLOR_A);
	}
}

void DrawTetris::MoveDown(void) { 
	if (InRange(x, y + 1, c, z)) {

		DrawBlock(COLOR_C);
		++y;
		DrawBlock(COLOR_A);
	}
	else if (y != -2) { // 触底
		DrawBlock(COLOR_B);

		for (int i = 0; i<4; ++i) {
			if (y + i<0) continue;
			for (int j = 0; j<4; ++j) {
				if (bk[c][z][i][j] == 1) {
					data[y + i][x + j] = 1;
				}
			}
		}

		RemoveRow();
		next = rand() % 7;
		x = 4, y = -2, c = next, z = 0;
		DrawNext();
	}
	else {
		Sleep(5000);
		DrawOver();
	}
}

void DrawTetris::DealKey(void) {
	int cycle = 9 - level;
	P = 1;
	bool play_music = 0;
	for (;;) {
		for (int i = 0; i < cycle; ++i) {
			if (kbhit()) { // 检查当前是否有键盘输入
				switch (getch()) {
				case VK_ESCAPE: //按esc 结束游戏
					return;
					break;
				case VK_SPACE: //按空格键 暂停游戏
					PlaySound(NULL, NULL, SND_FILENAME); 
					for (;;) {
						switch (getch()){
						case VK_ESCAPE:
							return;
						case VK_SPACE: //再次按下空格键或回车键 继续游戏
						case VK_RETURN:
							PlayMusic(P);
							goto LABLE_CONTINUE;
							break;
						}
					}
				LABLE_CONTINUE:
					break;

				case 61: //按等于 = 号，暂停\\播放音乐
					play_music ^= 1;
					if (!play_music) PlaySound(NULL, NULL, SND_FILENAME);
					else PlayMusic(P);
					break;

				case 45: //按减号 - 号，切换音乐
					P = (--P + 6) % 6;
					PlaySound(NULL, NULL, SND_FILENAME);
					PlayMusic(P);
					break;

				case 0xE0: //←↓→↑
				/* When reading a function key or an arrow key, _getch and _getche must be called twice; 
				   the first call returns 0 or 0xE0, and the second call returns the actual key code.*/
					switch (getch()) {
					case 0x4B: // ←
						MoveLeft();
						break;
					case 0x50: // ↓
						MoveDown();
						break;
					case 0x4D: // →
						MoveRight();
						break;
					case 0x48: //↑
						MoveTrans();
					default:
						break;
					}
					break;
				default:
					break;
				}
			}
			Sleep(55); // 55ms
		}
		MoveDown();
	}
}