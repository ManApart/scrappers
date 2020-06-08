package org.rak.scrappers.parts

val DEFAULT_HEAD = Part("basic_head", "Basic Head", PartType.HEAD, 10)
val DEFAULT_LEFT_ARM = Part("basic_left_arm", "Basic Left Arm", PartType.LEFT_ARM, 10)
val DEFAULT_RIGHT_ARM = Part("basic_right_arm", "Basic Right Arm", PartType.RIGHT_ARM, 10)
val DEFAULT_LEGS = Part("basic_legs", "Basic Legs", PartType.LEGS, 10)


class Part(val id: String, val name: String, val type: PartType, val totalHealth: Int) {
    var health = totalHealth;
}