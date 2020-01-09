using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Skip : MonoBehaviour
{
    public void skip(){
        Application.LoadLevel("Level Start Screen");
    }

    public void end(){
        Application.LoadLevel("Main Menu");
    }
}
