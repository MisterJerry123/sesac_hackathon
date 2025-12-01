# 2025 새싹 해커톤 AI 서비스 기획서 (Updated)

## 1. 서비스 개요 (Service Overview)

### 1.1 서비스명
**소리 비서 : Sori**

### 1.2 서비스 한줄 소개
**청각 장애인을 위한 실시간 대화 통역 및 환경 소리 시각화 비서**

### 1.3 개발 목표
청각 장애인이 일상생활에서 겪는 **소리 정보의 부재(위험 상황, 대화 맥락)**를 AI 기술로 해결하여 안전하고 독립적인 삶을 지원합니다.

### 1.4 타겟 사용자
**청각 장애인 및 난청인**
- 특히, 비언어적 소리 인지와 대화 맥락 파악에 어려움을 겪는 사용자

### 1.5 기대 효과
1.  **안전 사고 예방**: 위험 소리(경적, 사이렌 등)의 방향과 거리를 시각적으로 인지하여 사고를 예방합니다.
2.  **소통 능력 향상**: 대화의 텍스트 변환뿐만 아니라 감정 상태까지 파악하여 원활한 소통을 지원합니다.

---

## 2. 시스템 구성도 (System Architecture)

### 2.1 Input
- **Audio Stream**: 스마트폰 마이크를 통한 실시간 소리 입력

### 2.2 Processing (AI Engine)
- **Sound Analysis**:
    - 소리 감지 및 분류 (Sound Event Detection, SED) - **TensorFlow Lite (TFLite)**
    - 음원 위치 추정 (Direction of Arrival, DOA)
- **Speech Analysis**:
    - 음성 인식 (Speech-to-Text, STT)
    - 감정 분석 (Emotion Analysis) - **GPT API**

### 2.3 Output (User Interface)
- **Radar View**: 소리의 위치(방향, 거리) 시각화
- **Safety List**: 위험도에 따른 색상 구분 및 알림 리스트
- **Chat View**: 실시간 대화 내용 및 감정 이모티콘 표시

---

## 3. 핵심 기능 명세 (Key Features)

| 기능명 | 기능 설명 | 입력 데이터 | 출력 데이터 | 관련 기술 |
| :--- | :--- | :---: | :---: | :---: |
| **환경 소리 감지**<br>(Safety Monitoring) | 주변 소리를 분석하여 위험/일상 소리로 분류하고 위험도(High/Medium/Low)를 표시 | Audio | Class, Urgency | SED (TensorFlow Lite) |
| **음원 위치 시각화**<br>(Radar View) | 소리가 발생한 방향과 거리를 레이더 형태의 UI로 직관적으로 시각화 | Audio | Angle, Distance | DOA |
| **실시간 음성 인식**<br>(Voice Recognition) | 상대방의 음성을 실시간으로 텍스트로 변환하여 채팅 말풍선으로 표시 | Voice | Text | STT (Whisper 등) |
| **감정 분석**<br>(Emotion Analysis) | 대화 내용과 음성 톤을 분석하여 화자의 감정(긍정/부정/중립)을 아이콘으로 표시 | Voice/Text | Emotion | GPT API |
| **안전 알림**<br>(Safety Alert) | 위험도가 높은 소리(사이렌 등) 감지 시 붉은색 테두리 및 강조 표시로 즉각 알림 (백그라운드 환경에서도 진동 알림 제공) | Urgency | UI Color, Vibration | - |

---

## 4. 주요 기능 흐름 (User Flow)

### 4.1 메인 화면 (Home)
- 사용자는 상황에 따라 **'환경 소리 모드'**와 **'음성 인식 모드'** 중 하나를 선택하여 진입합니다.

### 4.2 환경 소리 모드 (Safety Mode)
1.  **소리 수집**: 주변 환경음을 실시간으로 수집 및 분석합니다.
2.  **시각화 (Radar)**: 소리의 방향(각도)과 거리(m)를 레이더 UI에 표시합니다.
3.  **알림 (List)**: 감지된 소리의 종류와 위험도에 따라 색상(빨강/주황/초록)을 구분하여 리스트에 표시합니다.

### 4.3 음성 인식 모드 (Communication Mode)
1.  **음성 수집**: 상대방의 음성을 수집합니다.
2.  **텍스트 변환**: 실시간으로 음성을 텍스트로 변환하여 채팅창에 표시합니다.
3.  **감정 분석 및 표시**: 변환된 텍스트를 **GPT API**로 분석하여 화자의 감정(예: 긍정, 부정)을 파악하고, 이를 이모티콘과 라벨로 말풍선 위에 표시하여 대화의 맥락을 전달합니다.

---

## 5. 향후 발전 방향 (Future Work)

1.  **웨어러블 기기 연동**: 스마트워치(Galaxy Watch 등)와 연동하여 핸드폰을 보지 않아도 손목 진동으로 위험 알림을 수신.
2.  **사용자 맞춤형 소리 등록 (Few-shot Learning)**: 우리 집 초인종 소리, 반려견 소리 등 사용자만의 고유한 소리를 직접 녹음하여 학습시키고 알림을 받는 기능.
3.  **온디바이스 감정 분석 (SLM)**: 현재 서버(GPT)를 거치는 감정 분석을 기기 내부의 경량 언어 모델(SLM)로 대체하여, 데이터 통신 없이도 빠르고 안전하게 감정을 분석.
4.  **AR 글래스 연동 (AR Glasses Integration)**: 스마트 안경과 연동하여, 사용자의 시야에 실시간 자막과 소리의 방향을 시각적으로 오버레이하여 직관적인 정보 제공.
# 2025 새싹 해커톤 AI 서비스 기획서 (Updated)

## 1. 서비스 개요 (Service Overview)

### 1.1 서비스명
**소리 비서 : Sori**

### 1.2 서비스 한줄 소개
**청각 장애인을 위한 실시간 대화 통역 및 환경 소리 시각화 비서**

### 1.3 개발 목표
청각 장애인이 일상생활에서 겪는 **소리 정보의 부재(위험 상황, 대화 맥락)**를 AI 기술로 해결하여 안전하고 독립적인 삶을 지원합니다.

### 1.4 타겟 사용자
**청각 장애인 및 난청인**
- 특히, 비언어적 소리 인지와 대화 맥락 파악에 어려움을 겪는 사용자

### 1.5 기대 효과
1.  **안전 사고 예방**: 위험 소리(경적, 사이렌 등)의 방향과 거리를 시각적으로 인지하여 사고를 예방합니다.
2.  **소통 능력 향상**: 대화의 텍스트 변환뿐만 아니라 감정 상태까지 파악하여 원활한 소통을 지원합니다.

---

## 2. 시스템 구성도 (System Architecture)

### 2.1 Input
- **Audio Stream**: 스마트폰 마이크를 통한 실시간 소리 입력

### 2.2 Processing (AI Engine)
- **Sound Analysis**:
    - 소리 감지 및 분류 (Sound Event Detection, SED) - **TensorFlow Lite (TFLite)**
    - 음원 위치 추정 (Direction of Arrival, DOA)
- **Speech Analysis**:
    - 음성 인식 (Speech-to-Text, STT)
    - 감정 분석 (Emotion Analysis) - **GPT API**

### 2.3 Output (User Interface)
- **Radar View**: 소리의 위치(방향, 거리) 시각화
- **Safety List**: 위험도에 따른 색상 구분 및 알림 리스트
- **Chat View**: 실시간 대화 내용 및 감정 이모티콘 표시

---

## 3. 핵심 기능 명세 (Key Features)

| 기능명 | 기능 설명 | 입력 데이터 | 출력 데이터 | 관련 기술 |
| :--- | :--- | :---: | :---: | :---: |
| **환경 소리 감지**<br>(Safety Monitoring) | 주변 소리를 분석하여 위험/일상 소리로 분류하고 위험도(High/Medium/Low)를 표시 | Audio | Class, Urgency | SED (TensorFlow Lite) |
| **음원 위치 시각화**<br>(Radar View) | 소리가 발생한 방향과 거리를 레이더 형태의 UI로 직관적으로 시각화 | Audio | Angle, Distance | DOA |
| **실시간 음성 인식**<br>(Voice Recognition) | 상대방의 음성을 실시간으로 텍스트로 변환하여 채팅 말풍선으로 표시 | Voice | Text | STT (Whisper 등) |
| **감정 분석**<br>(Emotion Analysis) | 대화 내용과 음성 톤을 분석하여 화자의 감정(긍정/부정/중립)을 아이콘으로 표시 | Voice/Text | Emotion | GPT API |
| **안전 알림**<br>(Safety Alert) | 위험도가 높은 소리(사이렌 등) 감지 시 붉은색 테두리 및 강조 표시로 즉각 알림 (백그라운드 환경에서도 진동 알림 제공) | Urgency | UI Color, Vibration | - |

---

## 4. 주요 기능 흐름 (User Flow)

### 4.1 메인 화면 (Home)
- 사용자는 상황에 따라 **'환경 소리 모드'**와 **'음성 인식 모드'** 중 하나를 선택하여 진입합니다.

### 4.2 환경 소리 모드 (Safety Mode)
1.  **소리 수집**: 주변 환경음을 실시간으로 수집 및 분석합니다.
2.  **시각화 (Radar)**: 소리의 방향(각도)과 거리(m)를 레이더 UI에 표시합니다.
3.  **알림 (List)**: 감지된 소리의 종류와 위험도에 따라 색상(빨강/주황/초록)을 구분하여 리스트에 표시합니다.

### 4.3 음성 인식 모드 (Communication Mode)
1.  **음성 수집**: 상대방의 음성을 수집합니다.
2.  **텍스트 변환**: 실시간으로 음성을 텍스트로 변환하여 채팅창에 표시합니다.
3.  **감정 분석 및 표시**: 변환된 텍스트를 **GPT API**로 분석하여 화자의 감정(예: 긍정, 부정)을 파악하고, 이를 이모티콘과 라벨로 말풍선 위에 표시하여 대화의 맥락을 전달합니다.

---

## 5. 향후 발전 방향 (Future Work)

1.  **웨어러블 기기 연동**: 스마트워치(Galaxy Watch 등)와 연동하여 핸드폰을 보지 않아도 손목 진동으로 위험 알림을 수신.
2.  **사용자 맞춤형 소리 등록 (Few-shot Learning)**: 우리 집 초인종 소리, 반려견 소리 등 사용자만의 고유한 소리를 직접 녹음하여 학습시키고 알림을 받는 기능.
3.  **온디바이스 감정 분석 (SLM)**: 현재 서버(GPT)를 거치는 감정 분석을 기기 내부의 경량 언어 모델(SLM)로 대체하여, 데이터 통신 없이도 빠르고 안전하게 감정을 분석.
4.  **AR 글래스 연동 (AR Glasses Integration)**: 스마트 안경과 연동하여, 사용자의 시야에 실시간 자막과 소리의 방향을 시각적으로 오버레이하여 직관적인 정보 제공.
5.  **멀티모달 상황 인지 (Multi-modal Context Awareness)**: 마이크(청각)뿐만 아니라 카메라(시각) 정보를 결합하여, "사이렌 소리"가 실제 구급차인지 TV 소리인지 구분하는 등 상황 인식 정확도 향상.

---

## 6. 부록 (Appendix)
* **원본 기획서**: 2025년 새싹 해커톤 AI 서비스 기획서.pdf
*   **기능 명세서**: AI 서비스 기능 명세서.md
*   **관련 연구 및 참고 문헌 (References)**:
    1.  **Sound Event Detection (SED)**
        *   Hershey, S., et al. (2017). "Audio Set: An ontology and human-labeled dataset for audio events." *IEEE ICASSP*. (YAMNet 학습 데이터셋)
        *   Howard, A. G., et al. (2017). "MobileNets: Efficient Convolutional Neural Networks for Mobile Vision Applications." *arXiv*. (YAMNet의 기반 아키텍처)
    2.  **Emotion Analysis (Multimodal)**
        *   OpenAI. (2023). "GPT-4 Technical Report." *arXiv*. (감정 분석 엔진 기반 기술)
        *   Lian, Z., et al. (2023). "Explainable Multimodal Emotion Recognition using Large Language Models." *arXiv*. (LLM을 활용한 멀티모달 감정 분석 연구)
    3.  **Direction of Arrival (DOA)**
        *   Knapp, C. & Carter, G. (1976). "The generalized correlation method for estimation of time delay." *IEEE Transactions on Acoustics, Speech, and Signal Processing*. (TDOA 및 Cross-Correlation 기반 위치 추정의 기초 이론)
        *   Zhang, Y., et al. (2018). "Real-time Sound Source Localization on Smartphones." *Proceedings of the 16th ACM Conference on Embedded Networked Sensor Systems*. (스마트폰 마이크를 활용한 실시간 음원 위치 추정)
    4.  **Speech Recognition (STT)**
        *   Google Developers. "Android SpeechRecognizer API Guide." (안드로이드 내장 음성 인식 기술 문서)
        *   Graves, A., et al. (2013). "Speech recognition with deep recurrent neural networks." *IEEE ICASSP*. (RNN-T 기반 음성 인식 모델 연구)
    5.  **Assistive Technology & System**
        *   Jain, D., et al. (2019). "HomeSound: An Iterative Field Deployment of an In-Home Sound Awareness System for the Deaf and Hard of Hearing." *CHI*. (청각 장애인을 위한 소리 인지 시스템 연구)
        *   Android Developers. "Foreground services." (백그라운드 감지 및 알림 시스템 구현 가이드)
