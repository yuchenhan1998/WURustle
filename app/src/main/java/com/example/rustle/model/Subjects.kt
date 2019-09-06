package com.example.rustle.model

import android.util.Log

class Subjects {
    private var subjects = ArrayList<String>()
    private var schoolsubject :MutableMap<String, ArrayList<String>> = mutableMapOf()
    private var architecture = ArrayList<String>()
    private var art = ArrayList<String>()
    private var artsciences = ArrayList<String>()
    private var business = ArrayList<String>()
    private var engineering = ArrayList<String>()
    private var law = ArrayList<String>()
    private var socialstudies = ArrayList<String>()
    private var visualarts = ArrayList<String>()

    init {
        subjects.addAll(listOf(

            //Architecture
            "ARCHITECTURE",

            //Art
            "ART",

            //Arts & Sciences
            "AFRICAN AND AFRICAN-AMERICAN STUDIES",
            "CHEMISTRY",
            "EAST ASIAN STUDIES",
            "JAPANESE",
            "MIND, BRAIN, AND BEHAVIOR",
            "PHYSICS",
            "RUSSIAN",
            "AMERICAN CULTURE STUDIES",
            "CHILDREN'S STUDIES",
            "ECONOMICS",
            "GERMAN",
            "JEWISH, ISLAMIC AND MIDDLE EAST STUDIES",
            "MOVEMENT SCIENCE",
            "POLITICAL ECONOMY",
            "RUSSIAN STUDIES",
            "ANTHROPOLOGY",
            "CHINESE",
            "EDUCATION",
            "GREEK",
            "KOREAN",
            "MUSIC",
            "POLITICAL SCIENCE",
            "SOCIOLOGY",
            "ARABIC",
            "CLASSICS",
            "ENGLISH LITERATURE",
            "HEBREW",
            "LATIN",
            "NURSING SCIENCE",
            "PORTUGUESE",
            "SPANISH",
            "ARCHAEOLOGY",
            "COLLEGE WRITING PROGRAM",
            "ENVIRONMENTAL STUDIES",
            "HINDI",
            "LATIN AMERICAN STUDIES",
            "PRAXIS",
            "SPEECH AND HEARING",
            "COMPARATIVE LITERATURE",
            "EUROPEAN STUDIES",
            "HISTORY",
            "LEGAL STUDIES",
            "PSYCHOLOGY",
            "ASIAN AMERICAN STUDIES",
            "DANCE",
            "FILM AND MEDIA STUDIES",
            "LINGUISTICS",
            "PHILOSOPHY",
            "RELIGION AND POLITICS",
            "URBAN STUDIES",
            "BIOLOGY AND BIOMEDICAL SCIENCES",
            "DRAMA",
            "FIRST-YEAR PROGRAMS",
            "INTERNATIONAL AND AREA STUDIES",
            "MATHEMATICS AND STATISTICS",
            "PHILOSOPHY-NEUROSCIENCE-PSYCHOLOGY",
            "RELIGIOUS STUDIES",
            "WOMEN, GENDER, AND SEXUALITY STUDIES",
            "CENTER FOR THE HUMANITIES",
            "EARTH AND PLANETARY SCIENCES",
            "FRENCH",
            "ART HISTORY",

            //Business School
            "MANAGEMENT",
            "ACCOUNTING",
            "ADMINISTRATION",
            "MANAGERIAL ECONOMICS",
            "DATA ANALYTICS",
            "MARKETING",
            "FINANCE",

            //Design & Visual Arts
            "DESIGN & VISUAL ARTS",

            //Engineering School
            "BIOMEDICAL ENGINEERING",
            "COMPUTER SCIENCE AND ENGINEERING",
            "ELECTRICAL AND SYSTEMS ENGINEERING",
            "ENERGY, ENVIRONMENTAL AND CHEMICAL ENGR",
            "GENERAL ENGINEERING",
            "MECHANICAL ENGINEERING",

            //law
            "LAW",

            //Social Work
            "SOCIAL STUDIES"
        ))
        architecture.addAll(listOf(
            "ARCHITECTURE"
        ))
        art.addAll(listOf(
            "ART"
        ))

        artsciences.addAll(listOf(
            "AFRICAN AND AFRICAN-AMERICAN STUDIES",
            "CHEMISTRY",
            "EAST ASIAN STUDIES",
            "JAPANESE",
            "MIND, BRAIN, AND BEHAVIOR",
            "PHYSICS",
            "RUSSIAN",
            "AMERICAN CULTURE STUDIES",
            "CHILDREN'S STUDIES",
            "ECONOMICS",
            "GERMAN",
            "JEWISH, ISLAMIC AND MIDDLE EAST STUDIES",
            "MOVEMENT SCIENCE",
            "POLITICAL ECONOMY",
            "RUSSIAN STUDIES",
            "ANTHROPOLOGY",
            "CHINESE",
            "EDUCATION",
            "GREEK",
            "KOREAN",
            "MUSIC",
            "POLITICAL SCIENCE",
            "SOCIOLOGY",
            "ARABIC",
            "CLASSICS",
            "ENGLISH LITERATURE",
            "HEBREW",
            "LATIN",
            "NURSING SCIENCE",
            "PORTUGUESE",
            "SPANISH",
            "ARCHAEOLOGY",
            "COLLEGE WRITING PROGRAM",
            "ENVIRONMENTAL STUDIES",
            "HINDI",
            "LATIN AMERICAN STUDIES",
            "PRAXIS",
            "SPEECH AND HEARING",
            "COMPARATIVE LITERATURE",
            "EUROPEAN STUDIES",
            "HISTORY",
            "LEGAL STUDIES",
            "PSYCHOLOGY",
            "ASIAN AMERICAN STUDIES",
            "DANCE",
            "FILM AND MEDIA STUDIES",
            "LINGUISTICS",
            "PHILOSOPHY",
            "RELIGION AND POLITICS",
            "URBAN STUDIES",
            "BIOLOGY AND BIOMEDICAL SCIENCES",
            "DRAMA",
            "FIRST-YEAR PROGRAMS",
            "INTERNATIONAL AND AREA STUDIES",
            "MATHEMATICS AND STATISTICS",
            "PHILOSOPHY-NEUROSCIENCE-PSYCHOLOGY",
            "RELIGIOUS STUDIES",
            "WOMEN, GENDER, AND SEXUALITY STUDIES",
            "CENTER FOR THE HUMANITIES",
            "EARTH AND PLANETARY SCIENCES",
            "FRENCH",
            "ART HISTORY"
        ))

        business.addAll(listOf(
            "MANAGEMENT",
            "ACCOUNTING",
            "ADMINISTRATION",
            "MANAGERIAL ECONOMICS",
            "DATA ANALYTICS",
            "MARKETING",
            "FINANCE"
        ))

        engineering.addAll(listOf(
            "BIOMEDICAL ENGINEERING",
            "COMPUTER SCIENCE AND ENGINEERING",
            "ELECTRICAL AND SYSTEMS ENGINEERING",
            "ENERGY, ENVIRONMENTAL AND CHEMICAL ENGR",
            "GENERAL ENGINEERING",
            "MECHANICAL ENGINEERING"
        ))

        law.addAll(listOf(
            "LAW"
        ))

        socialstudies.addAll(listOf(
            "SOCIAL STUDIES"
        ))

        visualarts.addAll(listOf(
            "DESIGN & VISUAL ARTS"
        ))

        schoolsubject.put("Architecture", architecture)
        schoolsubject.put("Art", art)
        schoolsubject.put("Design and Visual Arts", visualarts)
        schoolsubject.put("Arts and Sciences", artsciences)
        schoolsubject.put("Business", business)
        schoolsubject.put("Engineering", engineering)
        schoolsubject.put("Law", law)
        schoolsubject.put("Social Studies", socialstudies)

    }

    fun getSubjects() : ArrayList<String>{
        subjects.sort()
        return subjects
    }

    fun getSubjectsBySchool(school : String) : ArrayList<String>{
        var currentList = schoolsubject[school]
        if (currentList==null){
            Log.e("a", "b")
            return ArrayList()
        }
        else{
            currentList.sort()
            return currentList
        }
    }


}