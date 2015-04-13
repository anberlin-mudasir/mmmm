########################################
# 本makefile仅适用于windows平台下使用
########################################

CC =	gcc
TARGET =	myTetris.exe

OBJS = main.o enter_window.o set.o play_music.o\
	readme.o console.o draw_tetris.o

all:$(OBJS)
	$(CC) $(OBJS) -o $(TARGET) -lwinmm


main.o:main.cpp enter_window.o draw_tetris.o
	$(CC) -o $@ -c $<

draw_tetris.o:draw_tetris.cpp draw_tetris.h console.o
	$(CC) -o $@ -c $<
console.o:console.cpp console.h
	$(CC) -o $@ -c $<

enter_window.o:enter_window.cpp header.h\
	play_music.o set.o readme.o
	$(CC) -o $@ -c $<
set.o:set.cpp header.h
	$(CC) -o $@ -c $<
play_music.o:play_music.cpp header.h
	$(CC) -o $@ -c $< 
readme.o:readme.cpp header.h
	$(CC) -o $@ -c $<


.PHONY:
	all clean

clean:
	del -f $(OBJS) $(TARGET)