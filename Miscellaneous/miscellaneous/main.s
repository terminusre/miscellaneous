;******************** (C) COPYRIGHT HAW-Hamburg ********************************
;* File Name          : main.s
;* Author             : Alfred Lohmann
;* Version            : V1.0
;* Date               : 15.07.2012
;* Description        : This is a simple main.
;					  : The output is send to UART 1. Open Serial Window when 
;					  : when debugging. Select UART #1 in Serial Window selection.
;					  :
;					  : Replace this main with yours.
;
;*******************************************************************************


;********************************************
; Data section, aligned on 4-byte boundery
;********************************************
	
	AREA MyData, DATA, align = 4
		
	GLOBAL MyData, MeinNumFeld, MeinHaWoFeld, MeinTextFeld, MeinByteFeld, MeinBlock

MeinNumFeld 	DCD 	0x22, 2_00111110, -52, 78, 0x60000000, 0x50000000
	
MeinHaWoFeld 	DCW 	0x1234, 0x5678, 0x9abc, 0xdef0

MeinTextFeld 	DCB 	"ABab0123",0 

				ALIGN 	4
					
MeinByteFeld 	DCB 	0xef, 0xdc, 0xba, 0x98

				ALIGN 	4
					
MeinBlock 		SPACE 	0x20

;********************************************
; Code section, aligned on 8-byte boundery
;********************************************

	AREA MyCode, CODE, readonly, align = 4

;--------------------------------------------
; main subroutine
;--------------------------------------------

	GLOBAL main
	
main	PROC
		
		mov r0, #0x12 ; Anw-01
		
		mov r1, #-2 ; Anw-02
				
		ldr r2,=0xfe543210 ; Anw-03
		
		ldr r0,=MeinByteFeld ; Anw-04
				
		ldrb r1, [r0] ; Anw-05
		
		ldrh  r2, [r0] ; Anw-06
		ldr  r3, [r0] ; Anw-07
		
		ldr r4,=MeinHaWoFeld  ; Anw-08
		ldr r5, [r4] ; Anw-09
		ldr r6, [r4, #4] ; Anw-10
		
		ldr r0,=0x123456ab ; Anw-11
		ldr r1,=MeinBlock ; Anw-12
		str r0, [r1] ; Anw-13
		str r0, [r1, #4] ; Anw-14
		
		mov r2, #0x1a ; Anw-15
		strb r2, [r1, #9] ; Anw-16
		strb r2, [r1, #10] ; Anw-17
		
		ldr r0,=MeinNumFeld ; Anw-18
		ldr r1, [r0] ; Anw-19
		ldr r2, [r0, #4] ; Anw-20
		adds r3, r1, r2 ; Anw-21
		
		ldr r0,=MeinNumFeld+8 ; Anw-22
		ldr r1, [r0] ; Anw-23
		ldr r2, [r0, #4] ; Anw-24
		adds r3, r1, r2  ; Anw-25
		
		ldr r0,=MeinNumFeld+16 ; Anw-26
		ldr r1, [r0] ; Anw-27
		ldr r2, [r0, #4] ; Anw-28
		adds r3, r1, r2  ; Anw-29
		
		ldr r0,=MeinTextFeld ; Anw-30
		ldrb r1, [r0, #1]! ; Anw-31
		ldrb r1, [r0, #1]! ; Anw-32
		
		ldr r0,=MeinHaWoFeld ; Anw-33
		ldr r2, [r0], #4 ; Anw-34
		ldr r2, [r0], #4 ; Anw-35

		
forever	b	forever		; nowhere to retun if main ends		
		ENDP
	
		ALIGN
       
		END
		