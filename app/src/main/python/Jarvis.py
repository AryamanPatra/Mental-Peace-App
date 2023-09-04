import pyttsx3                   #pip install pyttsx3                 #  MUST Install these modules first
import speech_recognition as sr   #pip install speechRecognition
import datetime
import wikipedia                   #pip install wikipedia
import webbrowser
import os
import sys

engine = pyttsx3.init('sapi5')
voices = engine.getProperty('voices')
engine.setProperty('voice', voices[0].id)

def speak(audio):
    engine.say(audio)
    engine.runAndWait()

print("Starting J.A.R.V.I.S. program...")
print("I am Jarvis Sir. Please tell me how may I help you")
def wishMe():
    hour = int(datetime.datetime.now().hour)
    if hour>=0 and hour<12:
        speak("Good Morning!")
        
    elif hour>=12 and hour<18:
        speak("Good Afternoon!")   

    else:
        speak("Good Evening!")  

    speak("I am Jarvis Sir. Please tell me how may I help you")      
def takeCommand():

    r = sr.Recognizer()
    with sr.Microphone() as source:
        print("\nListening...")
        r.pause_threshold = 1
        audio = r.listen(source)

    try:
        print("Recognizing...")    
        query = r.recognize_google(audio, language='en-in')
        print(f"User said: {query}\n")

    except Exception as e:    
        print(">>>  I cant understand that.Say that again please...")  
        return "None"
    return query


if __name__ == "__main__":
    wishMe()
    while True:
        query = takeCommand().lower()
        # Logic for executing tasks based on query
        if 'wikipedia' in query:
            speak('Searching Wikipedia...')
            query = query.replace("wikipedia", "")
            results = wikipedia.summary(query, sentences=2)
            speak("According to Wikipedia")
            print(results)
            speak(results)
        elif 'who are you' in query:
            speak("Good day sir. I am J.A.R.V.I.S., an compyter program designed to assist you in various tasks")
            print("Good day sir. I am J.A.R.V.I.S., an compyter program designed to assist you in various tasks")

        elif 'open youtube' in query:
            speak("opening youtube")
            webbrowser.open("youtube.com")
            
        elif 'show movies' in query:
            speak("opening Netflix")
            webbrowser.open("netflix.com")

        elif 'open google' in query:
            speak("opening google")
            webbrowser.open("google.com")

        elif 'open spotify' in query:
            speak("opening spotify")
            webbrowser.open("spotify.com") 
        
        elif 'play music on spotify' in query or 'play music in spotify' in query:
            speak("opening spotify playlist")
            webbrowser.open("https://open.spotify.com/playlist/4AWpFDOYJM3OXMgEmS3qMp?si=4f536b808d3d443b")


        elif 'play music' in query:
            music_dir = 'D:\\songs'       #Copy the path of folder where you have musics
            songs = os.listdir(music_dir)   #Make sure the Musics run in VLC Media Player
            print(songs)    
            os.startfile(os.path.join(music_dir, songs[0]))
        elif 'stop music' in query:
            music_dir = 'D:\\songs'
            stop_vlc_command = 'TASKKILL /F /IM vlc.exe'
            os.system(stop_vlc_command)

        elif 'the time' in query:
            strTime = datetime.datetime.now().strftime("%H:%M:%S")
            print(f"Sir, the time is {strTime}")
            speak(f"Sir, the time is {strTime}")
            
        elif 'the date' in query:
            strDate = datetime.datetime.now().date()
            print(f"sir , the date is {strDate}")
            speak(f"sir , the date is {strDate}")

        elif 'shut down' in query or 'close' in query:
            print("Of course sir. Initiating system shutdown procedure. It was nice to talk to you sir.")
            speak("Of course sir. Initiating system shutdown procedure. It was nice to talk to you sir.")
            sys.exit()