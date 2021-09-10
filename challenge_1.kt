/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun isMatched(text:String,pattern:String):Boolean
{
    print("Inside")
    var lenText = text.length
    var lenPattern = pattern.length
    var textPointer=-1
    var patternPointer=-1
    var i=0
    var j=0

    if(lenPattern ==0)
    {
        return lenText==0
    }


    while(i<lenText)
    {
//rint(text[i]==pattern[j])
        if(j < lenPattern &&text[i]==pattern[j])
        {
            i=i.inc()
            j=j.inc()
        }
        else if(j< lenPattern&&pattern[j]=='?')
        {
            i=i.inc()
              j=j.inc()
        }
        else if(j<lenPattern&&pattern[j]=='*')
        {
            textPointer=i
                        patternPointer=j
                                       j=j.inc()
        }
        else if(patternPointer !=-1)
        {
            j=patternPointer+1
              i=textPointer+1
                textPointer=textPointer+1
        }
        else
        {
            return false;
        }

    }
    while (j < lenPattern && pattern[j] == '*')
    {
        j=j.inc()
    }
    if(j==lenPattern)
    {
        return true
    }
    return false
}

fun main()
{

    var text = "aa"

    var pattern = "a"
    //val stringInput = readLine()
    //println("You entered: $stringInput")
    var status = isMatched(text,pattern)
    print("Your Status: $status")
}
