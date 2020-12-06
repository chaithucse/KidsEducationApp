package com.neha.edu.common

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.neha.edu.R

class AppUtils {

    companion object {
        @JvmStatic
        fun getLetters(type: String): List<String> {
            if (type == "c") {
                return arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z").toMutableList()
            } else {
                return arrayOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z").toMutableList()
            }
        }

        @JvmStatic
        fun getColorDetails(): List<String> {
            return arrayOf("Amber", "Blue", "Red", "Brown", "Black", "Orange", "Green", "Yellow", "Cyan", "Indigo", "White", "Teal", "Lime", "Pink", "Purple").toMutableList()
        }

        @JvmStatic
        fun getShapesDetails(): List<String> {
            return arrayOf("Circle", "Diamond", "Hexagon", "Pentagon", "Rectangle", "Star", "Triangle", "Heart", "Square", "Arrow", "Oval", "Cone", "Cross", "Cylinder", "Cube").toMutableList()
        }

        @JvmStatic
        fun getColors(): List<Int> {
            return intArrayOf(R.color.amber, R.color.blue, R.color.red, R.color.brown, R.color.black, R.color.orange, R.color.green, R.color.yellow, R.color.cyan, R.color.indigo, R.color.white, R.color.teal, R.color.lime, R.color.pink, R.color.purple).toMutableList()
        }

        @JvmStatic
        fun getShapes(): List<Int> {
            return arrayOf(R.drawable.circle, R.drawable.diamond, R.drawable.hexagon, R.drawable.pentagon, R.drawable.rectangle, R.drawable.star, R.drawable.triangle, R.drawable.heart, R.drawable.square, R.drawable.arrow, R.drawable.oval, R.drawable.cone, R.drawable.cross, R.drawable.cylinder, R.drawable.cube).toMutableList()
        }

        @JvmStatic
        fun getFruitNames(): List<String> {
            return arrayOf("Apple", "Banana", "Blueberry", "Cherry", "Grapes", "Guava", "Kiwi", "Mango", "Orange", "Papaya", "Peaches", "Pear", "Pineapple", "Plum", "Raspberry", "Strawberry", "Watermelon"
            ).toMutableList()
        }

        @JvmStatic
        fun getFruitImages(): List<Int> {
            return arrayOf(R.drawable.apple, R.drawable.banana, R.drawable.blueberries, R.drawable.cherry, R.drawable.grapes, R.drawable.guava, R.drawable.kiwi, R.drawable.mango, R.drawable.orange, R.drawable.papaya, R.drawable.peaches, R.drawable.pear, R.drawable.pineapple,
                    R.drawable.plum, R.drawable.raspberry, R.drawable.strawberry, R.drawable.watermelon).toMutableList()
        }

        @JvmStatic
        fun getAnimalNames(): List<String> {
            return arrayOf("Bat", "Bear", "Bird", "Butterfly", "Camel", "Cat", "Chicken", "Chimpanzee", "Cow", "Crow", "Crocodile", "Deer", "Dinosaur", "Dog", "Dolphin", "Donkey", "Duck", "Eagle", "Elephant", "Fox", "Frog", "Giraffe", "Goat", "Gorilla", "Hippopotamus", "Horse", "Kangaroo", "Leopard", "Lion", "Mongoose", "Monkey", "Mouse", "Ostrich", "Octopus", "Owl", "Parrot", "Peacock", "Penguin", "Pig", "Rabbit", "Rhinoceros", "Rooster", "Scorpion", "Shark", "Sheep", "Squirrel", "Tiger", "Tortoise", "Wolf", "Zebra"
            ).toMutableList()
        }

        @JvmStatic
        fun getAnimalImages(): List<Int> {
            return arrayOf(R.drawable.bat, R.drawable.bear, R.drawable.bird, R.drawable.butterfly, R.drawable.camel, R.drawable.cat, R.drawable.chicken, R.drawable.chimpanzee, R.drawable.cow, R.drawable.crow, R.drawable.crocodile,
                    R.drawable.deer, R.drawable.dinosaur, R.drawable.dog, R.drawable.dolphin, R.drawable.donkey, R.drawable.duck, R.drawable.eagle, R.drawable.elephant, R.drawable.fox, R.drawable.frog, R.drawable.ziraffi,
                    R.drawable.goat, R.drawable.gorilla, R.drawable.hippo, R.drawable.horse, R.drawable.kangaroo, R.drawable.leopard, R.drawable.lion, R.drawable.mongoose, R.drawable.monkey, R.drawable.rat, R.drawable.ostrich,
                    R.drawable.octopus, R.drawable.owl, R.drawable.parrot, R.drawable.peacock, R.drawable.pengvin, R.drawable.pig, R.drawable.rabit, R.drawable.rhinoceros, R.drawable.roosters, R.drawable.scorpion, R.drawable.shark, R.drawable.sheep,
                    R.drawable.squirrel, R.drawable.tiger, R.drawable.tortoise, R.drawable.wolf, R.drawable.zebra
            ).toMutableList()
        }

        @JvmStatic
        fun getBodyNames(): List<String> {
            return arrayOf("Ear", "Eye", "Lips", "Leg", "Finger", "Hand", "Nose", "Hair", "Shoulder", "Stomach", "Teeth", "Toes", "Tongue", "Knee", "Nails", "Thumb", "Head").toMutableList()
        }

        @JvmStatic
        fun getBodyImages(): List<Int> {
            return arrayOf(R.drawable.ear, R.drawable.eye, R.drawable.lips, R.drawable.legs, R.drawable.finger, R.drawable.hand, R.drawable.nose, R.drawable.hair, R.drawable.shoulder, R.drawable.stomach, R.drawable.teeth, R.drawable.toe, R.drawable.toungue, R.drawable.knee, R.drawable.nails, R.drawable.thumb, R.drawable.head).toMutableList()
        }

        @JvmStatic
        fun getVegNames(): List<String> {
            return arrayOf("Beetroot", "Broccoli", "Cabbage", "Capsicum", "Carrot", "Cauliflower", "Corn", "Cucumber", "Eggplant", "Garlic", "Ginger", "Mushroom", "Okra", "Olive", "Onion", "Potato", "Radish", "Spinach").toMutableList()
        }

        @JvmStatic
        fun getVegImages(): List<Int> {
            return arrayOf(R.drawable.beetroot, R.drawable.broccoli, R.drawable.cabbage, R.drawable.red_capsicum, R.drawable.carrot, R.drawable.cauliflower, R.drawable.corn, R.drawable.cucumber, R.drawable.eggplant, R.drawable.garlic, R.drawable.ginger,
                    R.drawable.mushroom, R.drawable.okra, R.drawable.olive, R.drawable.onion, R.drawable.potato, R.drawable.raddish, R.drawable.spinacchi).toMutableList()
        }

        @JvmStatic
        fun getNumbers(type: Int): List<Int> {
            val list = mutableListOf<Int>()
            if (type == 1) {
                for (i in 0..100) {
                    list.add(i)
                }
            } else {
                for (i in 101..200) {
                    list.add(i)
                }
            }

            return list
        }

        @JvmStatic
        fun launchMoreApps(context: AppCompatActivity?) {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("market://search?q=pub:Techchai")
                context!!.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "Application not found", Toast.LENGTH_LONG).show()
            }
        }

        @JvmStatic
        fun shareApp(context: FragmentActivity?) {
            try {
                val playStoreLink =
                        "https://play.google.com/store/apps/details?id=" +
                                context!!.packageName
                val shareText = "NewsToday Application: $playStoreLink"
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, shareText)
                sendIntent.type = "text/plain"
                context.startActivity(Intent.createChooser(sendIntent, "Send To:"))
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(context, "Application not found", Toast.LENGTH_LONG).show()
            }
        }

        @JvmStatic
        fun shareFeedback(context: AppCompatActivity?) {
            try {
                val emailIntent = Intent(Intent.ACTION_SENDTO)
                emailIntent.data = Uri.parse("mailto: techchaimobile@gmail.com")
                context!!.startActivity(Intent.createChooser(emailIntent, "Send feedback"))
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(context, "Application not found", Toast.LENGTH_LONG).show()
            }
        }

        @JvmStatic
        fun getPackageVersion(context: FragmentActivity?): String {
            try {
                val pInfo: PackageInfo =
                        context!!.packageManager.getPackageInfo(context.getPackageName(), 0)
                return pInfo.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return ""
        }

        @JvmStatic
        fun rateApp(context: FragmentActivity?) {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("market://details?id=" + context?.getPackageName())
                context?.startActivity(intent)
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(context, "Application does not exist", Toast.LENGTH_SHORT).show()
            }
        }

        @JvmStatic
        fun launchAlphabetsApp(context: FragmentActivity?) {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("market://details?id=" + "com.neha.alphabets")
                context?.startActivity(intent)
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(context, "Application does not exist", Toast.LENGTH_SHORT).show()
            }
        }

        @JvmStatic
        fun launchPaintApp(context: FragmentActivity?) {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("market://details?id=" + "com.neha.slate")
                context?.startActivity(intent)
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(context, "Application does not exist", Toast.LENGTH_SHORT).show()
            }
        }

        @JvmStatic
        fun launchMultiApp(context: FragmentActivity?) {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("market://details?id=" + "com.neha.mathtable")
                context?.startActivity(intent)
            } catch (a: ActivityNotFoundException) {
                Toast.makeText(context, "Application does not exist", Toast.LENGTH_SHORT).show()
            }
        }
    }
}