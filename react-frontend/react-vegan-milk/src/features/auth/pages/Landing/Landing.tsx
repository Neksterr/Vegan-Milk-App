import { useNavigate } from "react-router-dom";
import styles from "./Landing.module.css";

 import bg from "@/assets/images/landing-bg.png";
import nearestMachineBg from "@/assets/images/nearest-machine-bg.png";
import heroLogo from "@/assets/images/landing-logo.png";
import machineImage from "@/assets/images/landing-machine.png";
import phoneStep1 from "@/assets/images/step-customize.png";
import phoneStep2 from "@/assets/images/step-pay.png";
import phoneStep3 from "@/assets/images/step-scan.png";
import nearestMachineImage from "@/assets/images/nearest-machine.png";
import skipLine from "@/assets/images/skip-line.png";
import saveRecipe from "@/assets/images/save-recipe.png";

export const Landing = () => {
  const navigate = useNavigate();

  return (
    <div className={styles.wrapper} style={{ backgroundImage: `url(${bg})` }}>
      <div className={styles.content}>
        <header className={styles.hero}>
          <div className={styles.brand}>
            <img
              src={heroLogo}
              alt="Smart Vegan Milk Network"
              className={styles.brandLogo}
            />

            <h1 className={styles.title}>
              Smart Vegan
              <br />
              Milk Network
            </h1>
          </div>

          <p className={styles.subtitle}>
            Fresh plant milk. Made for you.
            <br />
            Ready when you arrive.
          </p>

          <img
            src={machineImage}
            alt="Machine and bottle"
            className={styles.heroImage}
          />

          <button
            type="button"
            className={styles.primaryButton}
            onClick={() => navigate("/login")}
          >
            Explore Machines <span className={styles.arrow}>›</span>
          </button>
        </header>

        <section className={styles.sectionCard}>
          <h2 className={styles.sectionTitle}>How It Works</h2>

          <div className={styles.steps}>
            <div className={styles.stepCard}>
              <img
                src={phoneStep1}
                alt="Customize drink"
                className={styles.stepImage}
              />
              <h3 className={styles.stepTitle}>Customize drink</h3>
            </div>

            <div className={styles.stepCard}>
              <img
                src={phoneStep2}
                alt="Pay in app"
                className={styles.stepImage}
              />
              <h3 className={styles.stepTitle}>Pay in app</h3>
            </div>

            <div className={styles.stepCard}>
              <img
                src={phoneStep3}
                alt="Scan and collect"
                className={styles.stepImage}
              />
              <h3 className={styles.stepTitle}>Scan & collect</h3>
            </div>
          </div>
        </section>

        <section
          className={styles.sectionCard}
          style={{ backgroundImage: `url(${nearestMachineBg})` }}
        >
          <h2 className={styles.sectionTitle}>Nearest Machine</h2>

          <div className={styles.machineCard}>
            <img
              src={nearestMachineImage}
              alt="Nearest machine"
              className={styles.machineThumb}
            />

            <div className={styles.machineInfo}>
              <h3 className={styles.machineName}>Coldy Fit Gym</h3>

              <div className={styles.metaRow}>
                <span className={styles.distance}>450m</span>
              </div>

              <div className={styles.etaRow}>
                <span className={styles.etaLabel}>ETA</span>
                <span className={styles.etaValue}>5 min</span>
              </div>

              <div className={styles.readyInfo}>
                <p>3-Drinks- Ready</p>
                <p>⚡ Almond Energy Shot</p>
              </div>
            </div>
          </div>
        </section>

        <section className={styles.promoList}>
          <button type="button" className={styles.promoCard}>
            <div className={styles.promoContent}>
              <h3 className={styles.promoTitle}>Skip the Line</h3>
              <p className={styles.promoText}>
                Want to skip the queue? Order ahead for a faster pickup.
              </p>
            </div>

            <img
              src={skipLine}
              alt="Skip the line"
              className={styles.promoImage}
            />
          </button>

          <button type="button" className={styles.promoCard}>
            <div className={styles.promoContent}>
              <h3 className={styles.promoTitle}>Save Your Recipe</h3>
              <p className={styles.promoText}>
                Save your favorite blend and reorder it in seconds.
              </p>
            </div>

            <img
              src={saveRecipe}
              alt="Save your recipe"
              className={styles.promoImage}
            />
          </button>
        </section>
      </div>
    </div>
  );
};
