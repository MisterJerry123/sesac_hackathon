package com.misterjerry.test01.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misterjerry.test01.R
import com.misterjerry.test01.ui.theme.TenadaFontFamily

@Composable
fun HomeScreen(
    onNavigateToEnvSound: () -> Unit,
    onNavigateToVoiceRec: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "소리 비서 : Sori",
            style = MaterialTheme.typography.headlineLarge.copy(fontFamily = TenadaFontFamily),
            modifier = Modifier.padding(bottom = 32.dp)
        )

        ModeCard(
            title = "환경 소리 모드",
            icon = painterResource(id = R.drawable.icon_environment_sound_mode),
            description = "주변의 위험한 소리를 감지하고 알려줍니다.",
            onClick = onNavigateToEnvSound,
            color = Color.White,

            borderColor = Color(0x99DA070E), // #F630301A (RGBA) -> ARGB (Border)

            pressedColor = Color(0x1AF63030) // #DA070E99 (RGBA) -> ARGB (Pressed)
        )

        Spacer(modifier = Modifier.height(16.dp))

        ModeCard(
            title = "음성 인식 모드",
            icon = painterResource(id = R.drawable.icons_voice_recognition_mode),
            description = "대화를 실시간으로 텍스트로 변환합니다.",
            onClick = onNavigateToVoiceRec,
            color = Color.White,
            borderColor = Color(0x990044BA), // #0044BA1A (RGBA) -> ARGB (Border)
            pressedColor = Color(0x1A0044BA) // #0044BA99 (RGBA) -> ARGB (Pressed)
        )
    }
}

@Composable
fun ModeCard(
    title: String,
    icon: Painter,
    description: String,
    onClick: () -> Unit,
    color: Color,
    borderColor: Color,
    pressedColor: Color
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val containerColor = if (isPressed) pressedColor else color
    val contentColor = Color.Black

    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        border = BorderStroke(width = 1.dp, color = borderColor),
        interactionSource = interactionSource,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(fontFamily = TenadaFontFamily),
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = contentColor.copy(alpha = 0.8f)
            )
        }
    }
}
