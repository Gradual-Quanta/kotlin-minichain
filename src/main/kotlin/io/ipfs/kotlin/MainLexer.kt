package io.ipfs.kotlin

import java.io.File
import java.util.Stack
import java.lang.Character.MIN_VALUE as nullChar

fun main(args: Array<String>) {
  val (here, caller) = hereAndCaller()
  entering(here, caller)

  ParameterMap = parameterMapOfArguments(args)

  println ("Parameters are:")
  for ( (k, v) in ParameterMap) {
       println ("$k => $v")
  }

  writeLexemeList ()
  
  println("\nnormal termination")
  exiting(here)
}
