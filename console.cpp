#include "console.h"

Console::Console() {
	hStdOutput = INVALID_HANDLE_VALUE;
	hStdError = INVALID_HANDLE_VALUE;
}

bool Console::Open(void) {
	hStdOutput = GetStdHandle(STD_OUTPUT_HANDLE);
	hStdError = GetStdHandle(STD_ERROR_HANDLE);
	return INVALID_HANDLE_VALUE != hStdOutput && INVALID_HANDLE_VALUE != hStdError;
}

bool Console::SetTitle(const char * title) {
	return TRUE == SetConsoleTitle(title);
}

bool Console::RemoveCursor(void) {
	CONSOLE_CURSOR_INFO cci;
	if (!GetConsoleCursorInfo(hStdOutput, &cci)) return false;
	cci.bVisible = false;
	if (!SetConsoleCursorInfo(hStdOutput, &cci)) return false;
	if (!GetConsoleCursorInfo(hStdError, &cci)) return false;
	cci.bVisible = false;
	if (!SetConsoleCursorInfo(hStdError, &cci)) return false;
	return true;
}

bool Console::SetWindowRect(short x, short y) {
	SMALL_RECT wrt = { 0, 0, x, y };
	if (!SetConsoleWindowInfo(hStdOutput, TRUE, &wrt)) return false;
	if (!SetConsoleWindowInfo(hStdError, TRUE, &wrt)) return false;
	return true;
}

bool Console::SetBufSize(short x, short y) {
	COORD coord = { x, y };
	if (!SetConsoleScreenBufferSize(hStdOutput, coord)) return false;
	if (!SetConsoleScreenBufferSize(hStdError, coord)) return false;
	return true;
}

bool Console::GotoXY(short x, short y) {
	COORD coord = { x, y };
	if (!SetConsoleCursorPosition(hStdOutput, coord)) return false;
	if (!SetConsoleCursorPosition(hStdError, coord)) return false;
	return true;
}

bool Console::SetColor(WORD color) {
	if (!SetConsoleTextAttribute(hStdOutput, color)) return false;
	if (!SetConsoleTextAttribute(hStdError, color)) return false;
	return true;
}

bool Console::OutputString(const char* pstr, size_t len = 0) {
	DWORD n = 0;
	return TRUE == WriteConsole(hStdOutput, pstr, len ? len : strlen(pstr), &n, NULL);                                                                                                                                                                                                                                                                                                                                                                                                                
}

bool Console::OutputStringNoMove(short x, short y, const char* pstr, size_t len = 0) {
	COORD coord = { x, y };
	DWORD n = 0;
	return TRUE == WriteConsoleOutputCharacter(hStdOutput, pstr, len ? len : strlen(pstr), coord, &n);
}