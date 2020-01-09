using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FallenGround : MonoBehaviour
{
    private Mario mario;
    // Start is called before the first frame update
    void Start()
    {
        mario = FindObjectOfType<Mario> ();
    }

    // Update is called once per frame
    void Update()
    {
        if (((mario.gameObject.transform.position.x>=transform.position.x)&&(mario.gameObject.transform.position.x<=transform.position.x+2.5))&&(mario.gameObject.transform.position.y<=0.5))
        {
            Destroy(gameObject);
        }
    }
}
