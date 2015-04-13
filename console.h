#ifndef _CONSOLE_H_
#define _CONSOLE_H_

#include "header.h"

class Console {
public:
	Console();
	bool Open(void);
	bool SetTitle(const char* title); // ���ñ���
	bool RemoveCursor(void); // ȥ�����
	bool SetWindowRect(short, short); // ���ô���ߴ�
	bool SetBufSize(short, short); // ���û���ߴ�
	bool GotoXY(short, short); // �ƶ����
	bool SetColor(WORD); // ����ǰ��ɫ/����ɫ
	bool OutputString(const char*, size_t); // ����ַ���
	bool OutputStringNoMove(short, short, const char*, size_t); // ָ��λ�ã�����ַ���
private:
	HANDLE hStdOutput;
	HANDLE hStdError;
};

#endif /* _CONSOLE_H_ */