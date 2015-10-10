package _2_inheritance_examples;

public class Generalization {

    static class WritingPencil {
        // softness is HB by default
    }

    static class DrawingPencil extends WritingPencil {
        String softness; // B, HB, H
    }

}