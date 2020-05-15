package pl.agh.edu.dp.labirynth;

public class Wall extends MapSite {

    public Wall() {
    }

    @Override
    public void Enter(){

    }

    public static class CommonWall extends Wall{
        private boolean isCommon;

        public CommonWall() {
            super();
            this.isCommon = true;
        }
    }
}
