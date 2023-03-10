import cv2
import time
import mediapipe as mp

cap = cv2.VideoCapture(1)

mpHands = mp.solutions.hands
hands = mpHands.Hands()
mpDraw = mp.solutions.drawing_utils

while True:
    success, img = cap.read()
    imgRGB = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
    results = hands.process(imgRGB)

    # print(results.multi_hand_landmarks)

    if results.multi_hand_landmarks:
        for handLns in results.multi_hand_landmarks:
            mpDraw.draw_landmark

    cv2.imshow("Image", img)
    cv2.waitKey(1)
    
    
    ## i ll do it 
