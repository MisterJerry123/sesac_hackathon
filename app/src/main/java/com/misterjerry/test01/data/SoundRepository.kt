package com.misterjerry.test01.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

data class SoundEvent(
    val id: Long,
    val name: String,
    val direction: Float, // Degrees: 0 = Front, 90 = Right, -90 = Left
    val distance: Float, // Meters
    val urgency: Urgency
)

enum class Urgency {
    HIGH, MEDIUM, LOW
}

class SoundRepository {
    fun getSoundEvents(): Flow<List<SoundEvent>> = flow {
        while (true) {
            delay(3000) // Simulate detection every 3 seconds
            val events = mutableListOf<SoundEvent>()
            
            // Randomly add a dangerous sound
            if (Random.nextBoolean()) {
                events.add(
                    SoundEvent(
                        id = System.currentTimeMillis(),
                        name = if (Random.nextBoolean()) "사이렌" else "자동차 경적",
                        direction = Random.nextFloat() * 180 - 90,
                        distance = Random.nextFloat() * 10 + 1,
                        urgency = Urgency.HIGH
                    )
                )
            }

            // Randomly add a daily sound
            if (Random.nextBoolean()) {
                events.add(
                    SoundEvent(
                        id = System.currentTimeMillis() + 1,
                        name = if (Random.nextBoolean()) "초인종" else "개 짖는 소리",
                        direction = Random.nextFloat() * 180 - 90,
                        distance = Random.nextFloat() * 5 + 1,
                        urgency = Urgency.MEDIUM
                    )
                )
            }
            
            emit(events)
        }
    }
}
