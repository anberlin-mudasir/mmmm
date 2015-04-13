#ifndef _CONSOLE_H_
#define _CONSOLE_H_

#include "header.h"

class Console {
public:
	Console();
	bool Open(void);
	bool SetTitle(const char* title); // 设置标题
	bool RemoveCursor(void); // 去除光标
	bool SetWindowRect(short, short); // 设置窗体尺寸
	bool SetBufSize(short, short); // 设置缓冲尺寸
	bool GotoXY(short, short); // 移动光标
	bool SetColor(WORD); // 设置前景色/背景色
	bool OutputString(const char*, size_t); // 输出字符串
	bool OutputStringNoMove(short, short, const char*, size_t); // 指定位置，输出字符串
private:
	HANDLE hStdOutput;
	HANDLE hStdError;
};

#endif /* _CONSOLE_H_ */